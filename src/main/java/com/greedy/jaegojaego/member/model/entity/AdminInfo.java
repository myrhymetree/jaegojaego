package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "ADMIN_INFO")
@Embeddable
public class AdminInfo implements Serializable {

    @Column(name = "COMPANY_PHONE_NUMBER")
    private int companyPhoneNumber;


    @Column(name = "MEMBER_NO")
    private Integer memberNo;

}
