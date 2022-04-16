package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class MemberRolePK implements Serializable {

    @JoinColumn(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "AUTHORITY_CODE")
    private int authorityCode;

}
