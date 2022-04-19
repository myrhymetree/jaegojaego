package com.greedy.jaegojaego.client.model.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Client")
@Table(name = "TBL_CLIENT")
@SequenceGenerator(
        name = "CLIENT_SEQ_GENERATOR",
        sequenceName = "SEQ_CLIENT_NO",
        initialValue =  = 1,
        allocationSize = 1
)
public class Client {

    @Id
    @Column(name = "CLEINT_NO")
    @GeneratedValue{
        strategy = GenerationType.SEQUENCE,
        generator = "CLIENT_SEQ_GENERATOR"
    }
    private int clientNo;

    @Column(name = "CLIENT_NAME")
    public String cleintName;

    @Column(name = "CLIENT_CRETIFICATE_OF_BUSINESS_REGISTRATION_NO")
    public String clientCbrNo;

    @Column(name = "CLIENT_REPRESENTATIVE_NAME")
    public String clientRepresentativeName;

    @Column(name = "CLIENT_REPRESENTATIVE_PHONE")
    public String clientRepresentativePhone;

    @Column(name = "CLIENT_REPRESENTATIVE_EMAIL")
    public String clientRepresentativeEmail;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    public ClientMember clientMember;

    @Column(name = "CLIENT_CREATED_DATE")
    public Date clientCreatedDate;

    @Column(name = "CLIENT_PAYMENT_METHOD")
    public String clientPaymentMethod;


}
