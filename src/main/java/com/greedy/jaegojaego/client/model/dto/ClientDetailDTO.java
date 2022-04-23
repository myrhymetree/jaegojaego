package com.greedy.jaegojaego.client.model.dto;

import com.greedy.jaegojaego.client.model.entity.ClientContractItemCategory;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;

import java.util.Date;

public class ClientDetailDTO {

    private int clientNo;                                                           //파라미터로 받아온 해당 거래처 번호
    private String clientName;
    private String clientCbrNo;                                                     //거래처 사업자등록번호
    private String clientAddress;                                                   //거래처 주소
    private Date clientContractStartDate;                                           //거래처 계약 시작일
    private Date clientContractEndDate;                                             //거래처 계약 종료일
    private String ClientRepresentativeName;                                        //거래처 대표 이름
    private String clientRepresentativePhone;                                       //거래처 대표 핸드폰번호
    private String clientRepresentativeEmail;                                       //거래처 대표 이메일
    private ClientContractItemCategoryDTO clientContractItemCategory;               //거래처 판매 상품 카테고리
    private ClientMemberDTO clientMemberName;                                           //최후 수정자

    public ClientDetailDTO(){}

    public ClientDetailDTO(int clientNo, String clientName, String clientCbrNo, String clientAddress, Date clientContractStartDate, Date clientContractEndDate, String clientRepresentativeName, String clientRepresentativePhone, String clientRepresentativeEmail, ClientContractItemCategoryDTO clientContractItemCategory, ClientMemberDTO clientMemberName) {
        this.clientNo = clientNo;
        this.clientName = clientName;
        this.clientCbrNo = clientCbrNo;
        this.clientAddress = clientAddress;
        this.clientContractStartDate = clientContractStartDate;
        this.clientContractEndDate = clientContractEndDate;
        ClientRepresentativeName = clientRepresentativeName;
        this.clientRepresentativePhone = clientRepresentativePhone;
        this.clientRepresentativeEmail = clientRepresentativeEmail;
        this.clientContractItemCategory = clientContractItemCategory;
        this.clientMemberName = clientMemberName;
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

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Date getClientContractStartDate() {
        return clientContractStartDate;
    }

    public void setClientContractStartDate(Date clientContractStartDate) {
        this.clientContractStartDate = clientContractStartDate;
    }

    public Date getClientContractEndDate() {
        return clientContractEndDate;
    }

    public void setClientContractEndDate(Date clientContractEndDate) {
        this.clientContractEndDate = clientContractEndDate;
    }

    public String getClientRepresentativeName() {
        return ClientRepresentativeName;
    }

    public void setClientRepresentativeName(String clientRepresentativeName) {
        ClientRepresentativeName = clientRepresentativeName;
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

    public ClientContractItemCategoryDTO getClientContractItemCategory() {
        return clientContractItemCategory;
    }

    public void setClientContractItemCategory(ClientContractItemCategoryDTO clientContractItemCategory) {
        this.clientContractItemCategory = clientContractItemCategory;
    }

    public ClientMemberDTO getClientMemberName() {
        return clientMemberName;
    }

    public void setClientMemberName(ClientMemberDTO clientMemberName) {
        this.clientMemberName = clientMemberName;
    }

    @Override
    public String toString() {
        return "ClientDetailDTO{" +
                "clientNo=" + clientNo +
                ", clientName='" + clientName + '\'' +
                ", clientCbrNo='" + clientCbrNo + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientContractStartDate=" + clientContractStartDate +
                ", clientContractEndDate=" + clientContractEndDate +
                ", ClientRepresentativeName='" + ClientRepresentativeName + '\'' +
                ", clientRepresentativePhone='" + clientRepresentativePhone + '\'' +
                ", clientRepresentativeEmail='" + clientRepresentativeEmail + '\'' +
                ", clientContractItemCategory=" + clientContractItemCategory +
                ", clientMemberName=" + clientMemberName +
                '}';
    }
}
