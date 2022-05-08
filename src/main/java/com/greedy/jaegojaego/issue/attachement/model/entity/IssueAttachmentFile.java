package com.greedy.jaegojaego.issue.attachement.model.entity;

import com.greedy.jaegojaego.issue.issue.model.entity.Issue;

import javax.persistence.*;

@Entity(name = "issueAttachmentFile")
@Table(name = "ATTACHMENT_FILE")
@SequenceGenerator(
        name = "ISSUE_ATTACHMENT_FILE_SEQ_GENERATOR",
        sequenceName = "ATTACHMENT_FILE_NO",
        initialValue = 1,
        allocationSize = 1
)
public class IssueAttachmentFile {

    @Id
    @Column(name = "ATTACHMENT_FILE_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ISSUE_ATTACHMENT_FILE_SEQ_GENERATOR"
    )
    private int attachmentFileNo;

    @Column(name = "ATTACHMENT_FILE_ORIGINAL_NAME")
    private String attachmentFileOriginalName;

    @Column(name = "ATTACHMENT_FILE_CHANGED_NAME")
    private String attachmentFileChangedName;

    @Column(name = "ATTACHMENT_FILE_URL")
    private String attachmentFileUrl;

    @Column(name = "ATTACHMENT_FILE_DELETE_YN")
    private String attachmentFileDeleteYn;

    @ManyToOne
    @JoinColumn(name = "ATTACHMENT_FILE_CATEGORY_NO")
    private IssueAttachmentFileCategory issueAttachmentFileCategory;

    @Column(name = "ATTACHMENT_FILE_DIVISION")
    private String attachmentFileDivision;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ISSUE_NO")
    private Issue issue;

    @Column(name = "ATTACHMENT_FILE_THUMBNAIL_URL")
    private String attachmentFileThumbnailUrl;

    public IssueAttachmentFile() {
    }

    public IssueAttachmentFile(int attachmentFileNo, String attachmentFileOriginalName, String attachmentFileChangedName, String attachmentFileUrl, String attachmentFileDeleteYn, IssueAttachmentFileCategory issueAttachmentFileCategory, String attachmentFileDivision, Issue issue, String attachmentFileThumbnailUrl) {
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

    public IssueAttachmentFileCategory getIssueAttachmentFileCategory() {
        return issueAttachmentFileCategory;
    }

    public void setIssueAttachmentFileCategory(IssueAttachmentFileCategory issueAttachmentFileCategory) {
        this.issueAttachmentFileCategory = issueAttachmentFileCategory;
    }

    public String getAttachmentFileDivision() {
        return attachmentFileDivision;
    }

    public void setAttachmentFileDivision(String attachmentFileDivision) {
        this.attachmentFileDivision = attachmentFileDivision;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
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
        return "IssueAttachmentFile{" +
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
