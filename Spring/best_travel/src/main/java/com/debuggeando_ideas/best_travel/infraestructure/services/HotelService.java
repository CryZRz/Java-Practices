package com.debuggeando_ideas.best_travel.infraestructure.services;

import com.debuggeando_ideas.best_travel.api.models.responses.HotelResponse;
import com.debuggeando_ideas.best_travel.domain.entities.jpa.HotelEntity;
import com.debuggeando_ideas.best_travel.domain.entities.repositories.jpa.HotelRepositrory;
import com.debuggeando_ideas.best_travel.infraestructure.abstract_services.IHotelService;
import com.debuggeando_ideas.best_travel.util.constants.CacheConstants;
import com.debuggeando_ideas.best_travel.util.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class HotelService implements IHotelService {

    private final HotelRepositrory hotelRepositrory;
    @Override
    public Page<HotelResponse> readAll(Integer page, Integer size, SortType sortType) {
        PageRequest pageRequest = null;
        switch (sortType){
            case NONE -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT));
            case LOWER -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case UPPER -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
        return this.hotelRepositrory.findAll(pageRequest).map(this::entityToResponse);
    }

    @Override
    @Cacheable(value = CacheConstants.HOTEL_CACHE_NAME)
    public Set<HotelResponse> readLessPrice(BigDecimal price) {
        return this.hotelRepositrory.findByPriceLessThan(price)
                .stream()
                .map(this::entityToResponse)
                .collect(Collectors.toSet());
    }

    @Override
    @Cacheable(value = CacheConstants.HOTEL_CACHE_NAME)
    public Set<HotelResponse> readBetweenPrice(BigDecimal min, BigDecimal max) {
        return this.hotelRepositrory.findByPriceIsBetween(min, max)
                .stream()
                .map(this::entityToResponse)
                .collect(Collectors.toSet());
    }

    @Override
    @Cacheable(value = CacheConstants.HOTEL_CACHE_NAME)
    public Set<HotelResponse> readByRatingGreaterThan(Integer rating) {
        return this.hotelRepositrory.findByRatingGreaterThan(rating)
                .stream()
                .map(this::entityToResponse)
                .collect(Collectors.toSet());
    }

    private HotelResponse entityToResponse(HotelEntity entity){
        HotelResponse response = new HotelResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
