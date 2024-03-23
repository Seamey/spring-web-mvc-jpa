package com.example.springwebmvc.dto;

public record ProductEditRequest(
        String name,
        Double price
) {
}
