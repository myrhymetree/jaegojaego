package com.greedy.jaegojaego.client.model.dto;

import com.greedy.jaegojaego.client.model.entity.ClientMember;

import java.util.Date;
import java.util.List;

public class ClientInsertDTO {

    private int clientNo;
    private String clientName;
    private String clientCbrNo;
    private String clientRepresentativeName;
    private String clientRepresentativePhone;
    private String clientRepresentativeEmail;
    private ClientMember clientMemberNo;
    private Date clientCreatedDate;
    private String clientPaymentMethod;
    private String clientAddress;
    private List<ClientBusinessTypeDvisionDTO> clientBusinessTypeDvisionDTOList;
    private List<ClientBusinessItemDvisionDTO> clientBusinessItemDvisionDTOList;
    private List<ClientContractInfoDTO> clientContractInfoDTOList;

    public ClientInsertDTO(int clientNo, String clientName, String clientCbrNo, String clientRepresentativeName, String clientRepresentativePhone, String clientRepresentativeEmail, ClientMember clientMemberNo, Date clientCreatedDate, String clientPaymentMethod, String clientAddress, List<ClientBusinessTypeDvisionDTO> clientBusinessTypeDvisionDTOList, List<ClientBusinessItemDvisionDTO> clientBusinessItemDvisionDTOList, List<ClientContractInfoDTO> clientContractInfoDTOList) {
        this.clientNo = clientNo;
        this.clientName = clientName;
        this.clientCbrNo = clientCbrNo;
        this.clientRepresentativeName = clientRepresentativeName;
        this.clientRepresentativePhone = clientRepresentativePhone;
        this.clientRepresentativeEmail = clientRepresentativeEmail;
        this.clientMemberNo = clientMemberNo;
        this.clientCreatedDate = clientCreatedDate;
        this.clientPaymentMethod = clientPaymentMethod;
        this.clientAddress = clientAddress;
        this.clientBusinessTypeDvisionDTOList = clientBusinessTypeDvisionDTOList;
        this.clientBusinessItemDvisionDTOList = clientBusinessItemDvisionDTOList;
        this.clientContractInfoDTOList = clientContractInfoDTOList;
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

    public ClientMember getClientMemberNo() {
        return clientMemberNo;
    }

    public void setClientMemberNo(ClientMember clientMemberNo) {
        this.clientMemberNo = clientMemberNo;
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

    public List<ClientBusinessTypeDvisionDTO> getClientBusinessTypeDvisionDTOList() {
        return clientBusinessTypeDvisionDTOList;
    }

    public void setClientBusinessTypeDvisionDTOList(List<ClientBusinessTypeDvisionDTO> clientBusinessTypeDvisionDTOList) {
        this.clientBusinessTypeDvisionDTOList = clientBusinessTypeDvisionDTOList;
    }

    public List<ClientBusinessItemDvisionDTO> getClientBusinessItemDvisionDTOList() {
        return clientBusinessItemDvisionDTOList;
    }

    public void setClientBusinessItemDvisionDTOList(List<ClientBusinessItemDvisionDTO> clientBusinessItemDvisionDTOList) {
        this.clientBusinessItemDvisionDTOList = clientBusinessItemDvisionDTOList;
    }

    public List<ClientContractInfoDTO> getClientContractInfoDTOList() {
        return clientContractInfoDTOList;
    }

    public void setClientContractInfoDTOList(List<ClientContractInfoDTO> clientContractInfoDTOList) {
        this.clientContractInfoDTOList = clientContractInfoDTOList;
    }

    @Override
    public String toString() {
        return "ClientInsertDTO{" +
                "clientNo=" + clientNo +
                ", clientName='" + clientName + '\'' +
                ", clientCbrNo='" + clientCbrNo + '\'' +
                ", clientRepresentativeName='" + clientRepresentativeName + '\'' +
                ", clientRepresentativePhone='" + clientRepresentativePhone + '\'' +
                ", clientRepresentativeEmail='" + clientRepresentativeEmail + '\'' +
                ", clientMemberNo=" + clientMemberNo +
                ", clientCreatedDate=" + clientCreatedDate +
                ", clientPaymentMethod='" + clientPaymentMethod + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientBusinessTypeDvisionDTOList=" + clientBusinessTypeDvisionDTOList +
                ", clientBusinessItemDvisionDTOList=" + clientBusinessItemDvisionDTOList +
                ", clientContractInfoDTOList=" + clientContractInfoDTOList +
                '}';
    }
}
