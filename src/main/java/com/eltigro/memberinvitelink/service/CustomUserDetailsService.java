package com.eltigro.memberinvitelink.service;

import com.eltigro.memberinvitelink.domain.Member;
import com.eltigro.memberinvitelink.dto.CustomUserDetails;
import com.eltigro.memberinvitelink.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Member> findMember = memberRepository.findByEmail(email);

        return findMember.map(CustomUserDetails::new)
                .orElse(null);
    }
}
