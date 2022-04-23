package com.greedy.jaegojaego.client.model.dto;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;

import java.util.Date;
public class ClientDTO {

    private int clientNo;
    private String clientName;
    private String clientCbrNo;
    private String clientRepresentativeName;
    private String clientRepresentativePhone;
    private String clientRepresentativeEmail;
    private MemberDTO clientMemberName;
    private Date clientCreatedDate;
    private String clientPaymentMethod;

    public ClientDTO(){}

    public ClientDTO(int clientNo, String clientName, String clientCbrNo, String clientRepresentativeName, String clientRepresentativePhone, String clientRepresentativeEmail, MemberDTO clientMemberName, Date clientCreatedDate, String clientPaymentMethod) {

        this.clientNo = clientNo;
        this.clientName = clientName;
        this.clientCbrNo = clientCbrNo;
        this.clientRepresentativeName = clientRepresentativeName;
        this.clientRepresentativePhone = clientRepresentativePhone;
        this.clientRepresentativeEmail = clientRepresentativeEmail;
        this.clientMemberName = clientMemberName;
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

    public MemberDTO getClientMemberName() {
        return clientMemberName;
    }

    public void setClientMemberName(MemberDTO clientMemberName) {
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
        return "ClientDTO{" +
                "clientNo=" + clientNo +
                ", clientName='" + clientName + '\'' +
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
