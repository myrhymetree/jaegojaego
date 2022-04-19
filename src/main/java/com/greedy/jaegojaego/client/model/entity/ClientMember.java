package com.greedy.jaegojaego.client.model.entity;

import javax.persistence.*;

@Entity(name = "Client_Member_Name")
@Table(name = "COMPANY_ACCOUNT")
public class ClientMember {

    @Id
    @Column(name = "MEMBER_NO")
    public int clientMemberNo;

    @Column(name = "MEMBER_NAME")
    public String clientMemberName;

}


