package com.eltigro.memberinvitelink.repository;

import com.eltigro.memberinvitelink.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Boolean existsByEmail(String email);

    Optional<Member> findByInvitationId(UUID invitationId);
}
