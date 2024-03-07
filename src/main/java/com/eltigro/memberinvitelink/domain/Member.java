package com.eltigro.memberinvitelink.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String email;
    
    private String password;

    private String phoneNumber;

    @Builder.Default
    private String role = "ROLE_USER";

    @Builder.Default
    private boolean temporaryMember = false;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "invitation_id")
    private Invitation invitation;

    public static Member createTemporaryMember(String name, String email, String phoneNumber, Invitation invitation) {
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        member.setPhoneNumber(phoneNumber);
        member.setInvitation(invitation);
        member.setTemporaryMember(true);

        return member;
    }

    public void encryptPassword(PasswordEncoder passwordEncoder) {
        password = passwordEncoder.encode(password);
    }

    public void acceptInvite(){
        this.temporaryMember = false;
    }
}
