package com.greedy.jaegojaego.order.attachmentFile.entity;

import com.greedy.jaegojaego.issue.attachement.model.entity.IssueAttachmentFileCategory;
import com.greedy.jaegojaego.issue.issue.model.entity.Issue;
import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;

import javax.persistence.*;

@Entity(name = "orderAttachmentFile")
@Table(name = "ATTACHMENT_FILE")
@SequenceGenerator(
        name = "ORDER_ATTACHMENT_FILE_SEQ_GENERATOR",
        sequenceName = "ATTACHMENT_FILE_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OrderAttachmentFile {

    @Id
    @Column(name = "ATTACHMENT_FILE_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ORDER_ATTACHMENT_FILE_SEQ_GENERATOR"
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
    @JoinColumn(name = "ITEM_INFO_NO")
    private OrderItemInfo orderItemInfo;

    @Column(name = "ATTACHMENT_FILE_THUMBNAIL_URL")
    private String attachmentFileThumbnailUrl;

    public OrderAttachmentFile() {
    }

    public OrderAttachmentFile(int attachmentFileNo, String attachmentFileOriginalName, String attachmentFileChangedName, String attachmentFileUrl, String attachmentFileDeleteYn, IssueAttachmentFileCategory issueAttachmentFileCategory, String attachmentFileDivision, OrderItemInfo orderItemInfo, String attachmentFileThumbnailUrl) {
        this.attachmentFileNo = attachmentFileNo;
        this.attachmentFileOriginalName = attachmentFileOriginalName;
        this.attachmentFileChangedName = attachmentFileChangedName;
        this.attachmentFileUrl = attachmentFileUrl;
        this.attachmentFileDeleteYn = attachmentFileDeleteYn;
        this.issueAttachmentFileCategory = issueAttachmentFileCategory;
        this.attachmentFileDivision = attachmentFileDivision;
        this.orderItemInfo = orderItemInfo;
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

    public OrderItemInfo getOrderItemInfo() {
        return orderItemInfo;
    }

    public void setOrderItemInfo(OrderItemInfo orderItemInfo) {
        this.orderItemInfo = orderItemInfo;
    }

    public String getAttachmentFileThumbnailUrl() {
        return attachmentFileThumbnailUrl;
    }

    public void setAttachmentFileThumbnailUrl(String attachmentFileThumbnailUrl) {
        this.attachmentFileThumbnailUrl = attachmentFileThumbnailUrl;
    }

    @Override
    public String toString() {
        return "OrderAttachmentFile{" +
                "attachmentFileNo=" + attachmentFileNo +
                ", attachmentFileOriginalName='" + attachmentFileOriginalName + '\'' +
                ", attachmentFileChangedName='" + attachmentFileChangedName + '\'' +
                ", attachmentFileUrl='" + attachmentFileUrl + '\'' +
                ", attachmentFileDeleteYn='" + attachmentFileDeleteYn + '\'' +
                ", issueAttachmentFileCategory=" + issueAttachmentFileCategory +
                ", attachmentFileDivision='" + attachmentFileDivision + '\'' +
                ", orderItemInfo=" + orderItemInfo +
                ", attachmentFileThumbnailUrl='" + attachmentFileThumbnailUrl + '\'' +
                '}';
    }
}
