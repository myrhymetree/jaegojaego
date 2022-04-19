package com.greedy.jaegojaego.order.company.model.entity;

import com.greedy.jaegojaego.order.department.model.entity.OrderDepartment;
import lombok.*;

import javax.persistence.*;

@Entity(name = "companyAccount")
@Table(name = "COMPANY_ACCOUNT")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCompanyAccount {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_EMAIL")
    private String email;

    @Column(name = "MEMBER_CELLPHONE")
    private String cellphone;

    @ManyToOne
    @JoinColumn(name = "MEMBER_DEPARTMENT")
    private OrderDepartment orderDepartment;

    @Override
    public String toString() {
        return "CompanyAccount{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", department=" + orderDepartment +
                '}';
    }
}
