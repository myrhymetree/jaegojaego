package com.greedy.jaegojaego.issue.attachement.model.dto;

public class IssueAttachmentFileCategoryDTO {

    private int attachmentFileCategoryNo;
    private String attachmentFileCategoryName;

    public IssueAttachmentFileCategoryDTO() {
    }

    public IssueAttachmentFileCategoryDTO(int attachmentFileCategoryNo, String attachmentFileCategoryName) {
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
        return "IssueAttachementFileCategoryDTO{" +
                "attachmentFileCategoryNo=" + attachmentFileCategoryNo +
                ", attachmentFileCategoryName='" + attachmentFileCategoryName + '\'' +
                '}';
    }
}
