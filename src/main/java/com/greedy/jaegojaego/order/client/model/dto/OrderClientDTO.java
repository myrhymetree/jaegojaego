package com.greedy.jaegojaego.order.client.model.dto;

import com.greedy.jaegojaego.order.company.model.dto.OrderCompanyAccountDTO;
import lombok.*;

import java.sql.Date;

public class OrderClientDTO {

    private int clientNo;
    private String clientName;
    private String clientCetificateOfBusinessRegistrationNo;
    private String clientRepresentativeName;
    private String clientRepresentativePhone;
    private String clientRepresentativeEmail;
    private String clientAddress;
    private OrderCompanyAccountDTO companyAccount;
    private java.sql.Date clientCreatedDate;
    private String clientPaymentMethod;

    public OrderClientDTO() {
    }

    public OrderClientDTO(int clientNo, String clientName, String clientCetificateOfBusinessRegistrationNo, String clientRepresentativeName, String clientRepresentativePhone, String clientRepresentativeEmail, String clientAddress, OrderCompanyAccountDTO companyAccount, Date clientCreatedDate, String clientPaymentMethod) {
        this.clientNo = clientNo;
        this.clientName = clientName;
        this.clientCetificateOfBusinessRegistrationNo = clientCetificateOfBusinessRegistrationNo;
        this.clientRepresentativeName = clientRepresentativeName;
        this.clientRepresentativePhone = clientRepresentativePhone;
        this.clientRepresentativeEmail = clientRepresentativeEmail;
        this.clientAddress = clientAddress;
        this.companyAccount = companyAccount;
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

    public OrderCompanyAccountDTO getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(OrderCompanyAccountDTO companyAccount) {
        this.companyAccount = companyAccount;
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
        return "ClientDTO{" +
                "clientNo=" + clientNo +
                ", clientName='" + clientName + '\'' +
                ", clientCetificateOfBusinessRegistrationNo='" + clientCetificateOfBusinessRegistrationNo + '\'' +
                ", clientRepresentativeName='" + clientRepresentativeName + '\'' +
                ", clientRepresentativePhone='" + clientRepresentativePhone + '\'' +
                ", clientRepresentativeEmail='" + clientRepresentativeEmail + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", companyAccount=" + companyAccount +
                ", clientCreatedDate=" + clientCreatedDate +
                ", clientPaymentMethod='" + clientPaymentMethod + '\'' +
                '}';
    }
}
