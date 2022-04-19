package com.greedy.jaegojaego.client.model.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;

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
    @Column(name = "CLEINT_NO")
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
    public ClientMember clientMemberName;

    @Column(name = "CLIENT_CREATED_DATE")
    public Date clientCreatedDate;

    @Column(name = "CLIENT_PAYMENT_METHOD")
    public String clientPaymentMethod;

    public Client(int clientNo, String cleintName, String clientCbrNo, String clientRepresentativeName, String clientRepresentativePhone, String clientRepresentativeEmail, ClientMember clientMemberName, Date clientCreatedDate, String clientPaymentMethod) {
        this.clientNo = clientNo;
        this.cleintName = cleintName;
        this.clientCbrNo = clientCbrNo;
        this.clientRepresentativeName = clientRepresentativeName;
        this.clientRepresentativePhone = clientRepresentativePhone;
        this.clientRepresentativeEmail = clientRepresentativeEmail;
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

    public String getCleintName() {
        return cleintName;
    }

    public void setCleintName(String cleintName) {
        this.cleintName = cleintName;
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

    @Override
    public String toString() {
        return "Client{" +
                "clientNo=" + clientNo +
                ", cleintName='" + cleintName + '\'' +
                ", clientCbrNo='" + clientCbrNo + '\'' +
                ", clientRepresentativeName='" + clientRepresentativeName + '\'' +
                ", clientRepresentativePhone='" + clientRepresentativePhone + '\'' +
                ", clientRepresentativeEmail='" + clientRepresentativeEmail + '\'' +
                ", clientMemberName=" + clientMemberName +
                ", clientCreatedDate=" + clientCreatedDate +
                ", clientPaymentMethod='" + clientPaymentMethod + '\'' +
                '}';
    }
}
