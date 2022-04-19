package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "EmployeeInfo")
@Table(name = "EMPLOYEE_INFO")
public class EmployeeInfo implements Serializable {

    @Column(name = "OFFICE_PHONE_NUMBER")
    private String phone;

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;
}
