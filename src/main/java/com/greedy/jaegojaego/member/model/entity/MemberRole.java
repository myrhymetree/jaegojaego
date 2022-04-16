package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "MemberRole")
@Table(name = "MEMBER_ROLE")
@Embeddable
public class MemberRole {

    @EmbeddedId
    private MemberRolePK memberRolePK;

    @JoinColumn(name = "AUTHORITY_CODE", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Authority authority;

}
