package com.greedy.jaegojaego.client.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class ClientBusinessItemDivisionPK implements Serializable {
    @Column(name = "CLIENT_NO")
    private int clientNo;
    @Column(name = "CLIENT_BUSINESS_ITEM_NO")
    private int clientBusinessItemNo;

}

