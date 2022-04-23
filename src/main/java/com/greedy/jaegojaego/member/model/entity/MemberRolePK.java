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
@EqualsAndHashCode
@Embeddable
public class MemberRolePK implements Serializable {

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "AUTHORITY_CODE")
    private int authorityCode;

}
