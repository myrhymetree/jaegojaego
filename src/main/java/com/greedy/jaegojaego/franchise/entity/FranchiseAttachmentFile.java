package com.greedy.jaegojaego.franchise.entity;

import lombok.*;

import javax.persistence.*;

/**
 * <pre>
 * Class : FranchiseAttachmentFile
 * Comment : ATTACHMENT_FILE 테이블과 대응할 엔티티
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@SequenceGenerator(
        name = "ATTACHMENT_SEQ_GENERATOR",
        sequenceName = "ATTACHMENT_FILE_NO",
        initialValue = 1,
        allocationSize = 1
)
@Entity(name = "FranchiseAttachmentFile")
@Table(name = "ATTACHMENT_FILE")
public class FranchiseAttachmentFile {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ATTACHMENT_SEQ_GENERATOR"
    )
    @Column(name = "ATTACHMENT_FILE_NO")
    private Integer attachmentNo;

    @Column(name = "ATTACHMENT_FILE_ORIGINAL_NAME")
    private String attachmentFileOriginalName;

    @Column(name = "ATTACHMENT_FILE_CHANGED_NAME")
    private String attachmentFileChangedName;

    @Column(name = "ATTACHMENT_FILE_URL")
    private String attachmentFileURL;

    @Column(name = "ATTACHMENT_FILE_DELETE_YN")
    private String attachmentFileDeleteYn;

    @Column(name = "ATTACHMENT_FILE_CATEGORY_NO")
    private Integer attachmentFileCategoryNo;

    @Column(name = "ATTACHMENT_FILE_DIVISION")
    private String attachmentFileDivision;

    @Column(name = "FRANCHISE_REPRESENTATIVE_NO")
    private Integer franchiseRepresentativeNo;

    @Column(name = "FRANCHISE_CONTRACT_UPDATE_NO")
    private Integer franchiseContractUpdateNo;

    public FranchiseAttachmentFile() {}

    public FranchiseAttachmentFile(Integer attachmentNo, String attachmentFileOriginalName, String attachmentFileChangedName, String attachmentFileURL, String attachmentFileDeleteYn, Integer attachmentFileCategoryNo, String attachmentFileDivision, Integer franchiseRepresentativeNo, Integer franchiseContractUpdateNo) {
        this.attachmentNo = attachmentNo;
        this.attachmentFileOriginalName = attachmentFileOriginalName;
        this.attachmentFileChangedName = attachmentFileChangedName;
        this.attachmentFileURL = attachmentFileURL;
        this.attachmentFileDeleteYn = attachmentFileDeleteYn;
        this.attachmentFileCategoryNo = attachmentFileCategoryNo;
        this.attachmentFileDivision = attachmentFileDivision;
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
        this.franchiseContractUpdateNo = franchiseContractUpdateNo;
    }

    public Integer getAttachmentNo() {
        return attachmentNo;
    }

    public void setAttachmentNo(Integer attachmentNo) {
        this.attachmentNo = attachmentNo;
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

    public Integer getAttachmentFileCategoryNo() {
        return attachmentFileCategoryNo;
    }

    public void setAttachmentFileCategoryNo(Integer attachmentFileCategoryNo) {
        this.attachmentFileCategoryNo = attachmentFileCategoryNo;
    }

    public String getAttachmentFileDivision() {
        return attachmentFileDivision;
    }

    public void setAttachmentFileDivision(String attachmentFileDivision) {
        this.attachmentFileDivision = attachmentFileDivision;
    }

    public Integer getFranchiseRepresentativeNo() {
        return franchiseRepresentativeNo;
    }

    public void setFranchiseRepresentativeNo(Integer franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public Integer getFranchiseContractUpdateNo() {
        return franchiseContractUpdateNo;
    }

    public void setFranchiseContractUpdateNo(Integer franchiseContractUpdateNo) {
        this.franchiseContractUpdateNo = franchiseContractUpdateNo;
    }

    @Override
    public String toString() {
        return "FranchiseAttachmentFile{" +
                "attachmentNo=" + attachmentNo +
                ", attachmentFileOriginalName='" + attachmentFileOriginalName + '\'' +
                ", attachmentFileChangedName='" + attachmentFileChangedName + '\'' +
                ", attachmentFileURL='" + attachmentFileURL + '\'' +
                ", attachmentFileDeleteYn='" + attachmentFileDeleteYn + '\'' +
                ", attachmentFileCategoryNo=" + attachmentFileCategoryNo +
                ", attachmentFileDivision='" + attachmentFileDivision + '\'' +
                ", franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                ", franchiseContractUpdateNo=" + franchiseContractUpdateNo +
                '}';
    }
}
