package com.greedy.jaegojaego.order.attachmentFile.dto;

public class OrderAttachmentFileCategoryDTO {

    private int attachmentFileCategoryNo;
    private String attachmentFileCategoryName;

    public OrderAttachmentFileCategoryDTO() {
    }

    public OrderAttachmentFileCategoryDTO(int attachmentFileCategoryNo, String attachmentFileCategoryName) {
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
        return "OrderAttachmentFileCategoryDTO{" +
                "attachmentFileCategoryNo=" + attachmentFileCategoryNo +
                ", attachmentFileCategoryName='" + attachmentFileCategoryName + '\'' +
                '}';
    }
}
