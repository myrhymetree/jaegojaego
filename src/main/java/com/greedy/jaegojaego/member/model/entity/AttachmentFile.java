package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.naming.Name;
import javax.persistence.*;

/**
 * <pre>
 * Class : AttachmentFile
 * Comment : ATTACHMENT_FILE 테이블과 대응할 엔티티, 첨부파일을 담당한다.
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */

@Builder
@Entity
@Table(name = "ATTACHMENT_FILE")
public class AttachmentFile {

    @Id
    @Column(name = "ATTACHMENT_FILE_NO")
    private int attachmentFileNo;

    @Column(name = "ATTACHMENT_FILE_ORIGINAL_NAME")
    private String attachmentFileOriginName;

    @Column(name = "ATTACHMENT_FILE_CHANGED_NAME")
    private String attachmentFileChangedName;

    @Column(name = "ATTACHMENT_FILE_URL")
    private String attachmentFileURL;

    @Column(name = "ATTACHMENT_FILE_DELETE_YN")
    private String attachmentFileDeleteYn;

    @Column(name = "ATTACHMENT_FILE_CATEGORY_NO")
    private int attachmentFileCategoryNo;

    @Column(name = "ATTACHMENT_FILE_DIVISION")
    private String attachmentFileDivision;

    @Column(name = "COMPANY_NOTICE_NO")
    private Integer companyNoticeNo;

    @Column(name = "FRANCHISE_NOTICE_NO")
    private Integer franchiseNoticeNo;

    @Column(name = "CLIENT_CONTRACT_ITEM_NO")
    private Integer clientContractItemNo;

    @Column(name = "CLIENT_NO")
    private Integer clientNo;

    @Column(name = "FRANCHISE_ISSUE_NO")
    private Integer franchiseIssueNo;

    @Column(name = "FRANCHISE_REPRESENTATIVE_NO")
    private int franchiseRepresentativeNo;

    @Column(name = "FRANCHISE_CONTRACT_UPDATE_NO")
    private Integer franchiseContractNo;

    @Column(name = "ITEM_INFO_UNIFICATION_NO")
    private Integer itemInfoUnificationNo;

    public AttachmentFile() {}

    public AttachmentFile(int attachmentFileNo, String attachmentFileOriginName, String attachmentFileChangedName, String attachmentFileURL, String attachmentFileDeleteYn, int attachmentFileCategoryNo, String attachmentFileDivision, Integer companyNoticeNo, Integer franchiseNoticeNo, Integer clientContractItemNo, Integer clientNo, Integer franchiseIssueNo, int franchiseRepresentativeNo, Integer franchiseContractNo, Integer itemInfoUnificationNo) {
        this.attachmentFileNo = attachmentFileNo;
        this.attachmentFileOriginName = attachmentFileOriginName;
        this.attachmentFileChangedName = attachmentFileChangedName;
        this.attachmentFileURL = attachmentFileURL;
        this.attachmentFileDeleteYn = attachmentFileDeleteYn;
        this.attachmentFileCategoryNo = attachmentFileCategoryNo;
        this.attachmentFileDivision = attachmentFileDivision;
        this.companyNoticeNo = companyNoticeNo;
        this.franchiseNoticeNo = franchiseNoticeNo;
        this.clientContractItemNo = clientContractItemNo;
        this.clientNo = clientNo;
        this.franchiseIssueNo = franchiseIssueNo;
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
        this.franchiseContractNo = franchiseContractNo;
        this.itemInfoUnificationNo = itemInfoUnificationNo;
    }

    public int getAttachmentFileNo() {
        return attachmentFileNo;
    }

    public void setAttachmentFileNo(int attachmentFileNo) {
        this.attachmentFileNo = attachmentFileNo;
    }

    public String getAttachmentFileOriginName() {
        return attachmentFileOriginName;
    }

    public void setAttachmentFileOriginName(String attachmentFileOriginName) {
        this.attachmentFileOriginName = attachmentFileOriginName;
    }

    public String getAttachmentFileChangedName() {
        return attachmentFileChangedName;
    }

    public void setAttachmentFileChangedName(String attachmentFileChangedName) {
        this.attachmentFileChangedName = attachmentFileChangedName;
    }

    public String getAttachmentFileURL() {
        return attachmentFileURL;
    }

    public void setAttachmentFileURL(String attachmentFileURL) {
        this.attachmentFileURL = attachmentFileURL;
    }

    public String getAttachmentFileDeleteYn() {
        return attachmentFileDeleteYn;
    }

    public void setAttachmentFileDeleteYn(String attachmentFileDeleteYn) {
        this.attachmentFileDeleteYn = attachmentFileDeleteYn;
    }

    public int getAttachmentFileCategoryNo() {
        return attachmentFileCategoryNo;
    }

    public void setAttachmentFileCategoryNo(int attachmentFileCategoryNo) {
        this.attachmentFileCategoryNo = attachmentFileCategoryNo;
    }

    public String getAttachmentFileDivision() {
        return attachmentFileDivision;
    }

    public void setAttachmentFileDivision(String attachmentFileDivision) {
        this.attachmentFileDivision = attachmentFileDivision;
    }

    public Integer getCompanyNoticeNo() {
        return companyNoticeNo;
    }

    public void setCompanyNoticeNo(Integer companyNoticeNo) {
        this.companyNoticeNo = companyNoticeNo;
    }

    public Integer getFranchiseNoticeNo() {
        return franchiseNoticeNo;
    }

    public void setFranchiseNoticeNo(Integer franchiseNoticeNo) {
        this.franchiseNoticeNo = franchiseNoticeNo;
    }

    public Integer getClientContractItemNo() {
        return clientContractItemNo;
    }

    public void setClientContractItemNo(Integer clientContractItemNo) {
        this.clientContractItemNo = clientContractItemNo;
    }

    public Integer getClientNo() {
        return clientNo;
    }

    public void setClientNo(Integer clientNo) {
        this.clientNo = clientNo;
    }

    public Integer getFranchiseIssueNo() {
        return franchiseIssueNo;
    }

    public void setFranchiseIssueNo(Integer franchiseIssueNo) {
        this.franchiseIssueNo = franchiseIssueNo;
    }

    public int getFranchiseRepresentativeNo() {
        return franchiseRepresentativeNo;
    }

    public void setFranchiseRepresentativeNo(int franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public Integer getFranchiseContractNo() {
        return franchiseContractNo;
    }

    public void setFranchiseContractNo(Integer franchiseContractNo) {
        this.franchiseContractNo = franchiseContractNo;
    }

    public Integer getItemInfoUnificationNo() {
        return itemInfoUnificationNo;
    }

    public void setItemInfoUnificationNo(Integer itemInfoUnificationNo) {
        this.itemInfoUnificationNo = itemInfoUnificationNo;
    }

    @Override
    public String toString() {
        return "AttachmentFile{" +
                "attachmentFileNo=" + attachmentFileNo +
                ", attachmentFileOriginName='" + attachmentFileOriginName + '\'' +
                ", attachmentFileChangedName='" + attachmentFileChangedName + '\'' +
                ", attachmentFileURL='" + attachmentFileURL + '\'' +
                ", attachmentFileDeleteYn='" + attachmentFileDeleteYn + '\'' +
                ", attachmentFileCategoryNo=" + attachmentFileCategoryNo +
                ", attachmentFileDivision='" + attachmentFileDivision + '\'' +
                ", companyNoticeNo=" + companyNoticeNo +
                ", franchiseNoticeNo=" + franchiseNoticeNo +
                ", clientContractItemNo=" + clientContractItemNo +
                ", clientNo=" + clientNo +
                ", franchiseIssueNo=" + franchiseIssueNo +
                ", franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                ", franchiseContractNo=" + franchiseContractNo +
                ", itemInfoUnificationNo=" + itemInfoUnificationNo +
                '}';
    }
}
