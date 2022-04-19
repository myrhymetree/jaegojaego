package com.greedy.jaegojaego.client.model.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Client")
@Table(name = "TBLE")
@SequenceGenerator(
        name = "CLIENT_SEQ_GENERATOR",
        sequenceName = "SEQ_CLIENT_NO",
        initialValue =  = 1,
        allocationSize = 1
)
public class ClientMember {

    
}


