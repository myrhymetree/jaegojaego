package com.greedy.jaegojaego.client.model.entity;

import lombok.*;
import org.springframework.security.core.Transient;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "Client_Business_Item_Division")
@Table(name = "CLIENT_BUSINESS_ITEM_DIVISION")
public class ClientBusinessItemDivision {

    @EmbeddedId
    private ClientBusinessItemDivisionPK clientBusinessItemDivisionPK;

    @JoinColumn(name ="CLIENT_NO", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Client clientNo;

    @JoinColumn(name ="CLIENT_BUSINESS_ITEM_NO", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ClientBusinessItem clientBusinessItemNo;


}

