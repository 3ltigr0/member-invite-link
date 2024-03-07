package com.eltigro.memberinvitelink.controller;

import com.eltigro.memberinvitelink.dto.SignUpRequestDto;
import com.eltigro.memberinvitelink.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/users")
    public ResponseEntity<Void> signUp(@RequestBody @Valid SignUpRequestDto signUpRequestDto) {
        Long id = memberService.signUp(signUpRequestDto);
        return ResponseEntity.created(URI.create("/api/users/" + id)).build();
    }
}
