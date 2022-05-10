package com.greedy.jaegojaego.client.model.entity;

import com.greedy.jaegojaego.issue.attachement.model.entity.IssueAttachmentFileCategory;
import com.greedy.jaegojaego.issue.issue.model.entity.Issue;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "clientContractItemAttachmentFile")
@Table(name = "ATTACHMENT_FILE")
@SequenceGenerator(
        name = "CLIENT_CONTRACT_ITEM_ATTACHMENT_FILE_SEQ_GENERATOR",
        sequenceName = "ATTACHMENT_FILE_NO",
        initialValue = 1,
        allocationSize = 1
)
@Data
public class ClientContractItemAttachmentFile {

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

    @Column(name = "ATTACHMENT_FILE_DIVISION")
    private String attachmentFileDivision;

    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_ITEM_NO")
    private ClientContractItem clientContractItem;

    @Column(name = "ATTACHMENT_FILE_THUMBNAIL_URL")
    private String attachmentFileThumbnailUrl;
}
