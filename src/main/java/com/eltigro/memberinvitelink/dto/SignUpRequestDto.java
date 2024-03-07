package com.eltigro.memberinvitelink.dto;

import com.eltigro.memberinvitelink.domain.Member;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpRequestDto {

    @NotBlank
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull
    @Pattern(regexp = "^01(?:[016789])(?:\\d{7,8})$")
    private String phoneNumber;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .build();
    }
}
