package com.debuggeando_ideas.best_travel.infraestructure.services;

import com.debuggeando_ideas.best_travel.api.models.request.TicketRequest;
import com.debuggeando_ideas.best_travel.api.models.responses.FlyResponse;
import com.debuggeando_ideas.best_travel.api.models.responses.TicketResponse;
import com.debuggeando_ideas.best_travel.domain.entities.jpa.TicketEntity;
import com.debuggeando_ideas.best_travel.domain.entities.repositories.jpa.CustomerRepository;
import com.debuggeando_ideas.best_travel.domain.entities.repositories.jpa.FlyRepository;
import com.debuggeando_ideas.best_travel.domain.entities.repositories.jpa.TicketRepository;
import com.debuggeando_ideas.best_travel.infraestructure.abstract_services.ITicketService;
import com.debuggeando_ideas.best_travel.infraestructure.helper.BlackListHelper;
import com.debuggeando_ideas.best_travel.infraestructure.helper.CustomerHelper;
import com.debuggeando_ideas.best_travel.infraestructure.helper.EmailHelper;
import com.debuggeando_ideas.best_travel.util.BestTravelUtil;
import com.debuggeando_ideas.best_travel.util.enums.Tables;
import com.debuggeando_ideas.best_travel.util.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class TicketService implements ITicketService {

    private final FlyRepository flyRepository;
    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final CustomerHelper customerHelper;
    private final BlackListHelper blackListHelper;
    private final EmailHelper emailHelper;

    @Override
    public TicketResponse create(TicketRequest request) {
        this.blackListHelper.isBlackListCustomer(request.getIdClient());
        var fly = flyRepository.findById(request.getIdFly()).orElseThrow(() -> new IdNotFoundException(Tables.fly.name()));
        var customer = customerRepository.findById(request.getIdClient()).orElseThrow(() -> new IdNotFoundException(Tables.customer.name()));

        var ticketToPersist = TicketEntity.builder()
                .id(UUID.randomUUID())
                .fly(fly)
                .customer(customer)
                .price(fly.getPrice().add(charger_price_percentage))
                .purchaseDate(LocalDate.now())
                .arrivalDate(BestTravelUtil.getRandomSoon())
                .departureDate(BestTravelUtil.getRandomLatter())
                .build();
        var ticketPersisted = this.ticketRepository.save(ticketToPersist);

        this.customerHelper.incrase(customer.getDni(), TicketService.class);
        if (Objects.nonNull(request.getEmail())) this.emailHelper.sendMail(request.getEmail(), customer.getFullName(), Tables.ticket.name());
        log.info("Ticket saved whith id {}", ticketPersisted.getId());

        return this.entityToResponse(ticketPersisted);
    }

    @Override
    public TicketResponse read(UUID uuid) {
        var ticketFromDb = this.ticketRepository.findById(uuid).orElseThrow(() -> new IdNotFoundException(Tables.ticket.name()));
        return this.entityToResponse(ticketFromDb);
    }

    @Override
    public TicketResponse update(TicketRequest request, UUID uuid) {
        var ticketToUpdate = ticketRepository.findById(uuid).orElseThrow(() -> new IdNotFoundException(Tables.ticket.name()));
        var fly = flyRepository.findById(request.getIdFly()).orElseThrow(() -> new IdNotFoundException(Tables.fly.name()));
        ticketToUpdate.setFly(fly);
        ticketToUpdate.setPrice(fly.getPrice().add(charger_price_percentage));
        ticketToUpdate.setArrivalDate(BestTravelUtil.getRandomSoon());
        ticketToUpdate.setDepartureDate(BestTravelUtil.getRandomLatter());

        var ticketUpdated = this.ticketRepository.save(ticketToUpdate);
        log.info("ticket updated with id {}", ticketUpdated.getId());
        return this.entityToResponse(ticketUpdated);
    }

    @Override
    public void delete(UUID uuid) {
        var ticketToDelete = ticketRepository.findById(uuid).orElseThrow(() -> new IdNotFoundException(Tables.ticket.name()));
        this.ticketRepository.delete(ticketToDelete);
    }

    @Override
    public BigDecimal findPrice(Long flyId) {
        var fly = this.flyRepository.findById(flyId).orElseThrow(() -> new IdNotFoundException(Tables.fly.name()));

        return fly.getPrice().add(charger_price_percentage);
    }

    private TicketResponse entityToResponse(TicketEntity entity){
        var response = new TicketResponse();
        BeanUtils.copyProperties(entity, response);
        var flyResponse = new FlyResponse();
        BeanUtils.copyProperties(entity.getFly(), flyResponse);
        response.setFly(flyResponse);
        return response;
    }

    public static final BigDecimal charger_price_percentage = BigDecimal.valueOf(0.25);
}
