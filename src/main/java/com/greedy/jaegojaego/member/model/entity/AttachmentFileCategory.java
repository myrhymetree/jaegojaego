package com.greedy.jaegojaego.member.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ATTACHMENT_FILE_CATEGORY")
public class AttachmentFileCategory implements Serializable {

    @Id
    @Column(name = "ATTACHMENT_FILE_CATEGORY_NO")
    private int attachmentFileCategoryNo;

    @Column(name = "ATTACHMENT_FILE_CATEGORY_NAME")
    private String attachmentFileCategoryName;
}
