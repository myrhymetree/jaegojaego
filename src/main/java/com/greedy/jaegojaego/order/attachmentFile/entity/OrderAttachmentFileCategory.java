package com.greedy.jaegojaego.order.attachmentFile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "orderAttachmentFileCategory")
@Table(name = "ATTACHMENT_FILE_CATEGORY")
public class OrderAttachmentFileCategory {

    @Id
    @Column(name = "ATTACHMENT_FILE_CATEGORY_NO")
    private int attachmentFileCategoryNo;

    @Column(name = "ATTACHMENT_FILE_CATEGORY_NAME")
    private String attachmentFileCategoryName;

    public OrderAttachmentFileCategory() {
    }

    public OrderAttachmentFileCategory(int attachmentFileCategoryNo, String attachmentFileCategoryName) {
        this.attachmentFileCategoryNo = attachmentFileCategoryNo;
        this.attachmentFileCategoryName = attachmentFileCategoryName;
    }

    public int getAttachmentFileCategoryNo() {
        return attachmentFileCategoryNo;
    }

    public void setAttachmentFileCategoryNo(int attachmentFileCategoryNo) {
        this.attachmentFileCategoryNo = attachmentFileCategoryNo;
    }

    public String getAttachmentFileCategoryName() {
        return attachmentFileCategoryName;
    }

    public void setAttachmentFileCategoryName(String attachmentFileCategoryName) {
        this.attachmentFileCategoryName = attachmentFileCategoryName;
    }

    @Override
    public String toString() {
        return "OrderAttachmentFileCategory{" +
                "attachmentFileCategoryNo=" + attachmentFileCategoryNo +
                ", attachmentFileCategoryName='" + attachmentFileCategoryName + '\'' +
                '}';
    }
}
