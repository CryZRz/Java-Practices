package com.debuggeando_ideas.best_travel.api.models.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReservationRequest implements Serializable {

    @Size(min = 18, max = 20, message = "The size to a length between 10 and 20 characters")
    @NotBlank(message = "id client is mandatory")
    private String idClient;
    @Positive
    @NotNull(message = "id client is mandatory")
    private Long idHotel;
    @Min(value = 1, message = "Min one day to make reservation")
    @Max(value = 30, message = "Max 30 days to make reservation")
    @NotNull(message = "total days is mandatory")
    private Integer totalDays;
    @Email
    private String email;
}
