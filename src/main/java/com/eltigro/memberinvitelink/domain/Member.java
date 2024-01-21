package com.eltigro.memberinvitelink.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private boolean temporaryMember;

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

    public void acceptInvite(){
        this.temporaryMember = false;
    }
}
