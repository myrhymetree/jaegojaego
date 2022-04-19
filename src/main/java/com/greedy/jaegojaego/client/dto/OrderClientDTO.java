package com.greedy.jaegojaego.client.dto;

import com.greedy.jaegojaego.company.model.dto.OrderCompanyAccountDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
