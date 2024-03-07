package com.eltigro.memberinvitelink.controller;


import com.eltigro.memberinvitelink.dto.InviteRequestDto;
import com.eltigro.memberinvitelink.dto.InviteResponseDto;
import com.eltigro.memberinvitelink.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InvitationApiController {

    private final MemberService memberService;

    @PostMapping("/api/invite")
    public InviteResponseDto inviteMember(@RequestBody @Valid InviteRequestDto inviteRequestDto) {
        return memberService.invite(inviteRequestDto);
    }

    @PostMapping("/api/accept-invite/{inviteCode}")
    public ResponseEntity<Void> acceptInvite(@PathVariable("inviteCode") String inviteCode) {
        memberService.acceptInvite(inviteCode);
        return ResponseEntity.ok().build();
    }
}
