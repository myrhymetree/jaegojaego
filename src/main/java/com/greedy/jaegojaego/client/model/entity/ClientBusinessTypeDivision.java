package com.greedy.jaegojaego.client.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity(name = "Client_Business_Type_Division")
@Table(name = "CLIENT_BUSINESS_TYPE_DIVISION")
public class ClientBusinessTypeDivision implements Serializable {

    @EmbeddedId
    private ClientBusinessTypeDivisionPK clientBusinessTypeDivisionPK;

    @JoinColumn(name = "CLIENT_NO", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Client clientNo;


    @JoinColumn(name = "CLIENT_BUSINESS_TYPE_NO", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ClientBusinessType clientBusinessTypeNo;

}
