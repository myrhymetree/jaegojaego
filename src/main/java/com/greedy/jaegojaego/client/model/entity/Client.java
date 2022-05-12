package com.greedy.jaegojaego.client.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Client")
@Table(name = "CLIENT")
@SequenceGenerator(
        name = "CLIENT_SEQ_GENERATOR",
        sequenceName = "CLIENT_NO",
        initialValue = 1,
        allocationSize = 1
)
@Data
public class Client {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_SEQ_GENERATOR"
    )
    @Column(name = "CLIENT_NO")
    private int clientNo;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "CLIENT_CERTIFICATE_OF_BUSINESS_REGISTRATION_NO")
    private String clientCbrNo;

    @Column(name = "CLIENT_REPRESENTATIVE_NAME")
    private String clientRepresentativeName;

    @Column(name = "CLIENT_REPRESENTATIVE_PHONE")
    private String clientRepresentativePhone;

    @Column(name = "CLIENT_REPRESENTATIVE_EMAIL")
    private String clientRepresentativeEmail;

    @Column(name = "CLIENT_ADDRESS")
    private String clientAddress;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private ClientMember clientMember;

    @Column(name = "CLIENT_CREATED_DATE")
    private Date clientCreatedDate;

    @Column(name = "CLIENT_PAYMENT_METHOD")
    private String clientPaymentMethod;

    @OneToMany(mappedBy = "client")
    private List<ClientCbr> clientCbrList;


}
