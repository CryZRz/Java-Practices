package com.debuggeando_ideas.best_travel.api.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseErrorResponse implements Serializable {
    private String status;
    private Integer code;
}
