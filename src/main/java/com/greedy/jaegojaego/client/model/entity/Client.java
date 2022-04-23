package com.greedy.jaegojaego.client.model.entity;

import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Client")
@Table(name = "CLIENT")
@SequenceGenerator(
        name = "CLIENT_SEQ_GENERATOR",
        sequenceName = "SEQ_CLIENT_NO",
        initialValue = 1,
        allocationSize = 1
)
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
    private ClientMember clientMemberName;

    @Column(name = "CLIENT_CREATED_DATE")
    private Date clientCreatedDate;

    @Column(name = "CLIENT_PAYMENT_METHOD")
    private String clientPaymentMethod;

    public Client(int clientNo, String clientName, String clientCbrNo, String clientRepresentativeName, String clientRepresentativePhone, String clientRepresentativeEmail, String clientAddress, ClientMember clientMemberName, Date clientCreatedDate, String clientPaymentMethod) {
        this.clientNo = clientNo;
        this.clientName = clientName;
        this.clientCbrNo = clientCbrNo;
        this.clientRepresentativeName = clientRepresentativeName;
        this.clientRepresentativePhone = clientRepresentativePhone;
        this.clientRepresentativeEmail = clientRepresentativeEmail;
        this.clientAddress = clientAddress;
        this.clientMemberName = clientMemberName;
        this.clientCreatedDate = clientCreatedDate;
        this.clientPaymentMethod = clientPaymentMethod;
    }

    public Client() {

    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientCbrNo() {
        return clientCbrNo;
    }

    public void setClientCbrNo(String clientCbrNo) {
        this.clientCbrNo = clientCbrNo;
    }

    public String getClientRepresentativeName() {
        return clientRepresentativeName;
    }

    public void setClientRepresentativeName(String clientRepresentativeName) {
        this.clientRepresentativeName = clientRepresentativeName;
    }

    public String getClientRepresentativePhone() {
        return clientRepresentativePhone;
    }

    public void setClientRepresentativePhone(String clientRepresentativePhone) {
        this.clientRepresentativePhone = clientRepresentativePhone;
    }

    public String getClientRepresentativeEmail() {
        return clientRepresentativeEmail;
    }

    public void setClientRepresentativeEmail(String clientRepresentativeEmail) {
        this.clientRepresentativeEmail = clientRepresentativeEmail;
    }

    public ClientMember getClientMemberName() {
        return clientMemberName;
    }

    public void setClientMemberName(ClientMember clientMemberName) {
        this.clientMemberName = clientMemberName;
    }

    public Date getClientCreatedDate() {
        return clientCreatedDate;
    }

    public void setClientCreatedDate(Date clientCreatedDate) {
        this.clientCreatedDate = clientCreatedDate;
    }

    public String getClientPaymentMethod() {
        return clientPaymentMethod;
    }

    public void setClientPaymentMethod(String clientPaymentMethod) {
        this.clientPaymentMethod = clientPaymentMethod;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientNo=" + clientNo +
                ", clientName='" + clientName + '\'' +
                ", clientCbrNo='" + clientCbrNo + '\'' +
                ", clientRepresentativeName='" + clientRepresentativeName + '\'' +
                ", clientRepresentativePhone='" + clientRepresentativePhone + '\'' +
                ", clientRepresentativeEmail='" + clientRepresentativeEmail + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientMemberName=" + clientMemberName +
                ", clientCreatedDate=" + clientCreatedDate +
                ", clientPaymentMethod='" + clientPaymentMethod + '\'' +
                '}';
    }
}
