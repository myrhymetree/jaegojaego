package com.greedy.jaegojaego.warehouse.entity;

import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "warehouseClient")
@Table(name = "CLIENT")
@SequenceGenerator(
        name = "CLIENT_SEQ_GENERATOR",
        sequenceName = "CLIENT_NO",
        initialValue = 1,
        allocationSize = 1
)
public class WarehouseClient {

    @Id
    @Column(name = "CLIENT_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_SEQ_GENERATOR"
    )
    private int clientNo;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "CLIENT_CERTIFICATE_OF_BUSINESS_REGISTRATION_NO")
    private String clientCetificateOfBusinessRegistrationNo;

    @Column(name = "CLIENT_REPRESENTATIVE_NAME")
    private String clientRepresentativeName;

    @Column(name = "CLIENT_REPRESENTATIVE_PHONE")
    private String clientRepresentativePhone;

    @Column(name = "CLIENT_REPRESENTATIVE_EMAIL")
    private String clientRepresentativeEmail;

    @Column(name = "CLIENT_ADDRESS")
    private String clientAddress;

    @Column(name = "MEMBER_NO")
    private int warehouseCompanyAccount;

    @Column(name = "CLIENT_CREATED_DATE")
    private java.sql.Date clientCreatedDate;

    @Column(name = "CLIENT_PAYMENT_METHOD")
    private String clientPaymentMethod;

    public WarehouseClient() {}

    public WarehouseClient(int clientNo, String clientName, String clientCetificateOfBusinessRegistrationNo, String clientRepresentativeName, String clientRepresentativePhone, String clientRepresentativeEmail, String clientAddress, int warehouseCompanyAccount, Date clientCreatedDate, String clientPaymentMethod) {
        this.clientNo = clientNo;
        this.clientName = clientName;
        this.clientCetificateOfBusinessRegistrationNo = clientCetificateOfBusinessRegistrationNo;
        this.clientRepresentativeName = clientRepresentativeName;
        this.clientRepresentativePhone = clientRepresentativePhone;
        this.clientRepresentativeEmail = clientRepresentativeEmail;
        this.clientAddress = clientAddress;
        this.warehouseCompanyAccount = warehouseCompanyAccount;
        this.clientCreatedDate = clientCreatedDate;
        this.clientPaymentMethod = clientPaymentMethod;
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

    public String getClientCetificateOfBusinessRegistrationNo() {
        return clientCetificateOfBusinessRegistrationNo;
    }

    public void setClientCetificateOfBusinessRegistrationNo(String clientCetificateOfBusinessRegistrationNo) {
        this.clientCetificateOfBusinessRegistrationNo = clientCetificateOfBusinessRegistrationNo;
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

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public int getWarehouseCompanyAccount() {
        return warehouseCompanyAccount;
    }

    public void setWarehouseCompanyAccount(int warehouseCompanyAccount) {
        this.warehouseCompanyAccount = warehouseCompanyAccount;
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
        return "WarehouseClient{" +
                "clientNo=" + clientNo +
                ", clientName='" + clientName + '\'' +
                ", clientCetificateOfBusinessRegistrationNo='" + clientCetificateOfBusinessRegistrationNo + '\'' +
                ", clientRepresentativeName='" + clientRepresentativeName + '\'' +
                ", clientRepresentativePhone='" + clientRepresentativePhone + '\'' +
                ", clientRepresentativeEmail='" + clientRepresentativeEmail + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", warehouseCompanyAccount=" + warehouseCompanyAccount +
                ", clientCreatedDate=" + clientCreatedDate +
                ", clientPaymentMethod='" + clientPaymentMethod + '\'' +
                '}';
    }
}
