package com.greedy.jaegojaego.member.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "AttachmentKind")
@Table(name = "ATTACHMENT_KIND")
public class AttachmentKind implements Serializable {

    @Id
    @Column(name = "ATTACHMENT_KIND_NO")
    private int kindNo;

    @Column(name = "ATTACHMENT_KIND_NAME")
    private String kindName;
}
