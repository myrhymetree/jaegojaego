package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.naming.Name;
import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

}
