package com.eltigro.memberinvitelink.service;

import com.eltigro.memberinvitelink.domain.Invitation;
import com.eltigro.memberinvitelink.domain.Member;
import com.eltigro.memberinvitelink.dto.InviteRequestDto;
import com.eltigro.memberinvitelink.dto.InviteResponseDto;
import com.eltigro.memberinvitelink.exception.ExistingMemberException;
import com.eltigro.memberinvitelink.exception.InvalidInvitationException;
import com.eltigro.memberinvitelink.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public InviteResponseDto invite(InviteRequestDto inviteRequestDto) {
        validateDuplicateEmail(inviteRequestDto.getEmail());

        Invitation invitation = Invitation.createInvitation();
        Member member = Member.createTemporaryMember(
                inviteRequestDto.getName(),
                inviteRequestDto.getEmail(),
                inviteRequestDto.getPhoneNumber(),
                invitation);
        memberRepository.save(member);

        return new InviteResponseDto(member.getInvitation().getId().toString());
    }

    @Transactional
    public void acceptInvite(String inviteCode) {
        UUID invitationId;
        try {
            invitationId = UUID.fromString(inviteCode);
        } catch (IllegalArgumentException e) {
            throw new InvalidInvitationException();
        }

        Optional<Member> findMember = memberRepository.findByInvitationId(invitationId);

        if (findMember.isPresent()) {
            Member member = findMember.get();

            if (member.getInvitation().isInvitationExpired()) {
                throw new InvalidInvitationException();
            }
            else {
                member.getInvitation().useInvitation();
                member.acceptInvite();
            }
        }
        else {
            throw new InvalidInvitationException();
        }
    }

    public void validateDuplicateEmail(String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new ExistingMemberException();
        }
    }
}
