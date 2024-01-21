package com.eltigro.memberinvitelink.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
public class Invitation {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "invitation_id")
    private UUID id;

    private LocalDateTime expireDate;

    private boolean used;

    @OneToOne(mappedBy = "invitation", fetch = FetchType.LAZY)
    private Member member;

    public static Invitation createInvitation() {
        Invitation invitation = new Invitation();
        invitation.setExpireDate(LocalDateTime.now().plusHours(24));
        invitation.setUsed(false);

        return invitation;
    }

    public boolean isInvitationExpired() {
        LocalDateTime currentTime = LocalDateTime.now();

        return this.expireDate.isBefore(currentTime) || this.used;
    }

    public void useInvitation() {
        this.used = true;
    }
}
