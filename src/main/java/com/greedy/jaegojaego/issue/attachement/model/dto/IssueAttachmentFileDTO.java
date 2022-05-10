package com.greedy.jaegojaego.issue.attachement.model.dto;

import com.greedy.jaegojaego.issue.issue.model.dto.IssueDTO;

public class IssueAttachmentFileDTO {

    private int attachmentFileNo;
    private String attachmentFileOriginalName;
    private String attachmentFileChangedName;
    private String attachmentFileUrl;
    private String attachmentFileDeleteYn;
    private IssueAttachmentFileCategoryDTO issueAttachmentFileCategory;
    private String attachmentFileDivision;
    private IssueDTO issue;
    private String attachmentFileThumbnailUrl;

    public IssueAttachmentFileDTO() {
    }

    public IssueAttachmentFileDTO(int attachmentFileNo, String attachmentFileOriginalName, String attachmentFileChangedName, String attachmentFileUrl, String attachmentFileDeleteYn, IssueAttachmentFileCategoryDTO issueAttachmentFileCategory, String attachmentFileDivision, IssueDTO issue, String attachmentFileThumbnailUrl) {
        this.attachmentFileNo = attachmentFileNo;
        this.attachmentFileOriginalName = attachmentFileOriginalName;
        this.attachmentFileChangedName = attachmentFileChangedName;
        this.attachmentFileUrl = attachmentFileUrl;
        this.attachmentFileDeleteYn = attachmentFileDeleteYn;
        this.issueAttachmentFileCategory = issueAttachmentFileCategory;
        this.attachmentFileDivision = attachmentFileDivision;
        this.issue = issue;
        this.attachmentFileThumbnailUrl = attachmentFileThumbnailUrl;
    }

    public int getAttachmentFileNo() {
        return attachmentFileNo;
    }

    public void setAttachmentFileNo(int attachmentFileNo) {
        this.attachmentFileNo = attachmentFileNo;
    }

    public String getAttachmentFileOriginalName() {
        return attachmentFileOriginalName;
    }

    public void setAttachmentFileOriginalName(String attachmentFileOriginalName) {
        this.attachmentFileOriginalName = attachmentFileOriginalName;
    }

    public String getAttachmentFileChangedName() {
        return attachmentFileChangedName;
    }

    public void setAttachmentFileChangedName(String attachmentFileChangedName) {
        this.attachmentFileChangedName = attachmentFileChangedName;
    }

    public String getAttachmentFileUrl() {
        return attachmentFileUrl;
    }

    public void setAttachmentFileUrl(String attachmentFileUrl) {
        this.attachmentFileUrl = attachmentFileUrl;
    }

    public String getAttachmentFileDeleteYn() {
        return attachmentFileDeleteYn;
    }

    public void setAttachmentFileDeleteYn(String attachmentFileDeleteYn) {
        this.attachmentFileDeleteYn = attachmentFileDeleteYn;
    }

    public IssueAttachmentFileCategoryDTO getIssueAttachmentFileCategory() {
        return issueAttachmentFileCategory;
    }

    public void setIssueAttachmentFileCategory(IssueAttachmentFileCategoryDTO issueAttachmentFileCategory) {
        this.issueAttachmentFileCategory = issueAttachmentFileCategory;
    }

    public String getAttachmentFileDivision() {
        return attachmentFileDivision;
    }

    public void setAttachmentFileDivision(String attachmentFileDivision) {
        this.attachmentFileDivision = attachmentFileDivision;
    }

    public IssueDTO getIssue() {
        return issue;
    }

    public void setIssue(IssueDTO issue) {
        this.issue = issue;
    }

    public String getAttachmentFileThumbnailUrl() {
        return attachmentFileThumbnailUrl;
    }

    public void setAttachmentFileThumbnailUrl(String attachmentFileThumbnailUrl) {
        this.attachmentFileThumbnailUrl = attachmentFileThumbnailUrl;
    }

    @Override
    public String toString() {
        return "IssueAttachmentFileDTO{" +
                "attachmentFileNo=" + attachmentFileNo +
                ", attachmentFileOriginalName='" + attachmentFileOriginalName + '\'' +
                ", attachmentFileChangedName='" + attachmentFileChangedName + '\'' +
                ", attachmentFileUrl='" + attachmentFileUrl + '\'' +
                ", attachmentFileDeleteYn='" + attachmentFileDeleteYn + '\'' +
                ", issueAttachmentFileCategory=" + issueAttachmentFileCategory +
                ", attachmentFileDivision='" + attachmentFileDivision + '\'' +
                ", issue=" + issue +
                ", attachmentFileThumbnailUrl='" + attachmentFileThumbnailUrl + '\'' +
                '}';
    }
}
