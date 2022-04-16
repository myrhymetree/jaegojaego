package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "AdminInfo")
@Table(name = "ADMIN_INFO")
public class AdminInfo implements Serializable {

    @Column(name = "COMPANY_PHONE_NUMBER")
    private int companyPhoneNumber;

    @Id
    @Column(name = "MEMBER_NO")
    private Integer memberNo;

}
