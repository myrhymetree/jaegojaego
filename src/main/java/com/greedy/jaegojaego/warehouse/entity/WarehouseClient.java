package com.greedy.jaegojaego.warehouse.entity;

import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;
import lombok.*;

import javax.persistence.*;

@Entity(name = "warehouseClient")
@Table(name = "CLIENT")
@SequenceGenerator(
        name = "CLIENT_SEQ_GENERATOR",
        sequenceName = "CLIENT_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private OrderCompanyAccount orderCompanyAccount;

    @Column(name = "CLIENT_CREATED_DATE")
    private java.sql.Date clientCreatedDate;

    @Column(name = "CLIENT_PAYMENT_METHOD")
    private String clientPaymentMethod;

    @Override
    public String toString() {
        return "Client{" +
                "clientNo=" + clientNo +
                ", clientName='" + clientName + '\'' +
                ", clientCetificateOfBusinessRegistrationNo='" + clientCetificateOfBusinessRegistrationNo + '\'' +
                ", clientRepresentativeName='" + clientRepresentativeName + '\'' +
                ", clientRepresentativePhone='" + clientRepresentativePhone + '\'' +
                ", clientRepresentativeEmail='" + clientRepresentativeEmail + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", companyAccount=" + orderCompanyAccount +
                ", clientCreatedDate=" + clientCreatedDate +
                ", clientPaymentMethod='" + clientPaymentMethod + '\'' +
                '}';
    }
}
