package com.debuggeando_ideas.best_travel.api.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TourRequest implements Serializable {
    public String customerId;
    public Set<TourFlyRequest> flights;
    public Set<TourHotelRequest> hotels;
    public String email;
}
