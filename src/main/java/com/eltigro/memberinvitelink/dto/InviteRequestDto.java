package com.eltigro.memberinvitelink.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InviteRequestDto {
    @NotBlank
    String name;

    @NotBlank
    @Email
    String email;

    @NotBlank
    String phoneNumber;
}
