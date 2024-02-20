package com.hampcode.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class OrderRequest {
    @NotBlank(message = "AccountId is required")
    @Size(max = 10, message = "AccountId must be less than 10 characters")
    private String accountId;
}