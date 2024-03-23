package com.example.springwebmvc.dto.categorydto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank
                @Size(max = 40)
        String name,
        String description
) {
}
