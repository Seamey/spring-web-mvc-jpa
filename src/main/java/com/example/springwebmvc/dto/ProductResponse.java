package com.example.springwebmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductResponse(


        String uuid,
        @NotBlank
        String name,
        @NotNull
        Double price,
        Integer qty
) {

}
