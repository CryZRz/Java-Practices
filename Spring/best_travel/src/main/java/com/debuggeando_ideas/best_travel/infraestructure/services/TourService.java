package com.debuggeando_ideas.best_travel.infraestructure.services;

import com.debuggeando_ideas.best_travel.api.models.request.TourRequest;
import com.debuggeando_ideas.best_travel.api.models.responses.TourResponse;
import com.debuggeando_ideas.best_travel.domain.entities.jpa.*;
import com.debuggeando_ideas.best_travel.domain.entities.repositories.jpa.CustomerRepository;
import com.debuggeando_ideas.best_travel.domain.entities.repositories.jpa.FlyRepository;
import com.debuggeando_ideas.best_travel.domain.entities.repositories.jpa.HotelRepositrory;
import com.debuggeando_ideas.best_travel.domain.entities.repositories.jpa.TourRepository;
import com.debuggeando_ideas.best_travel.infraestructure.abstract_services.ITourService;
import com.debuggeando_ideas.best_travel.infraestructure.helper.BlackListHelper;
import com.debuggeando_ideas.best_travel.infraestructure.helper.CustomerHelper;
import com.debuggeando_ideas.best_travel.infraestructure.helper.EmailHelper;
import com.debuggeando_ideas.best_travel.infraestructure.helper.TourHelper;
import com.debuggeando_ideas.best_travel.util.enums.Tables;
import com.debuggeando_ideas.best_travel.util.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
@AllArgsConstructor
@Slf4j
public class TourService implements ITourService {

    private final TourRepository tourRepository;
    private final FlyRepository flyRepository;
    private final HotelRepositrory hotelRepositrory;
    private final CustomerRepository customerRepository;
    private final TourHelper tourHelper;
    private final CustomerHelper customerHelper;
    private final BlackListHelper blackListHelper;
    private final EmailHelper emailHelper;

    @Override
    public void removeTicket(Long tourId, UUID ticketId) {
        var tourToUpdate = this.tourRepository.findById(tourId).orElseThrow(() -> new IdNotFoundException(Tables.tour.name()));
        tourToUpdate.removeTicket(ticketId);
        this.tourRepository.save(tourToUpdate);
    }

    @Override
    public UUID addTicket(Long flyId, Long tourId) {
        var tourToUpdate = this.tourRepository.findById(tourId).orElseThrow(() -> new IdNotFoundException(Tables.tour.name()));
        var fly = this.flyRepository.findById(flyId).orElseThrow(() -> new IdNotFoundException(Tables.fly.name()));
        var ticket = this.tourHelper.createTicket(fly, tourToUpdate.getCustomer());

        tourToUpdate.addTicket(ticket);
        this.tourRepository.save(tourToUpdate);

        return ticket.getId();
    }

    @Override
    public void removeReservation(Long tourId, UUID reservationId) {
        var tourToUpdate = this.tourRepository.findById(tourId).orElseThrow(() -> new IdNotFoundException(Tables.tour.name()));
        tourToUpdate.removeReservation(reservationId);
        this.tourRepository.save(tourToUpdate);
    }

    @Override
    public UUID addReservation(Long hotelId, Long tourId, Integer totalDays) {
        var tourToUpdate = this.tourRepository.findById(tourId).orElseThrow(() -> new IdNotFoundException(Tables.tour.name()));
        var hotel = this.hotelRepositrory.findById(hotelId).orElseThrow(() -> new IdNotFoundException(Tables.hotel.name()));
        var reservation = this.tourHelper.createReservation(hotel, tourToUpdate.getCustomer(), totalDays);

        tourToUpdate.addReservation(reservation);
        this.tourRepository.save(tourToUpdate);

        return reservation.getId();
    }

    @Override
    public TourResponse crate(TourRequest request) {
        //this.blackListHelper.isBlackListCustomer(request.getCustomerId());
        var customer = customerRepository.findById(request.getCustomerId()).orElseThrow(() -> new IdNotFoundException(Tables.customer.name()));
        var flights = new HashSet<FlyEntity>();
        request.getFlights().forEach(fly -> flights.add(this.flyRepository.findById(fly.getId()).orElseThrow(() -> new IdNotFoundException(Tables.fly.name()))));
        var hotels = new HashMap<HotelEntity, Integer>();
        request.getHotels().forEach(hotel -> hotels.put(this.hotelRepositrory.findById(hotel.getId()).orElseThrow(() -> new IdNotFoundException(Tables.hotel.name())), hotel.getTotalDays()));

        var tourToSave = TourEntity.builder()
                .tickets(this.tourHelper.createTickets(flights, customer))
                .reservations(this.tourHelper.createReservations(hotels, customer))
                .customer(customer)
                .build();

        var tourSaved = this.tourRepository.save(tourToSave);

        this.customerHelper.incrase(customer.getDni(), TourService.class);
        //if (Objects.nonNull(request.getEmail())) this.emailHelper.sendMail(request.getEmail(), customer.getFullName(), Tables.tour.name());

        return TourResponse.builder()
                .reservationIds(tourToSave.getReservations().stream().map(ReservationEntity::getId).collect(Collectors.toSet()))
                .ticketIds(tourToSave.getTickets().stream().map(TicketEntity::getId).collect(Collectors.toSet()))
                .id(tourToSave.getId())
                .build();
    }

    @Override
    public TourResponse read(Long id) {
        var tourFromDb = this.tourRepository.findById(id).orElseThrow(() -> new IdNotFoundException(Tables.tour.name()));

        return TourResponse.builder()
                .reservationIds(tourFromDb.getReservations().stream().map(ReservationEntity::getId).collect(Collectors.toSet()))
                .ticketIds(tourFromDb.getTickets().stream().map(TicketEntity::getId).collect(Collectors.toSet()))
                .id(tourFromDb.getId())
                .build();
    }

    @Override
    public void delete(Long id) {
        var tourToDelete = this.tourRepository.findById(id).orElseThrow(() -> new IdNotFoundException(Tables.tour.name()));
        this.tourRepository.delete(tourToDelete);
    }
}
