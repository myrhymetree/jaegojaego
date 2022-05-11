package com.greedy.jaegojaego.client.model.entity;

import com.greedy.jaegojaego.issue.attachement.model.entity.IssueAttachmentFileCategory;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "clientCbr")
@Table(name = "ATTACHMENT_FILE")
@SequenceGenerator(
        name = "CLIENT_CBR_SEQ_GENERATOR",
        sequenceName = "ATTACHMENT_FILE_NO",
        initialValue = 1,
        allocationSize = 1
)
@Data
public class ClientCbr {

    @Id
    @Column(name = "ATTACHMENT_FILE_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_CBR_SEQ_GENERATOR_SEQ_GENERATOR"
    )
    private int clientCbrNo;

    @Column(name = "ATTACHMENT_FILE_ORIGINAL_NAME")
    private String clientCbrOriginalName;

    @Column(name = "ATTACHMENT_FILE_CHANGED_NAME")
    private String clientCbrChangedName;

    @Column(name = "ATTACHMENT_FILE_URL")
    private String clientCbrUrl;

    @Column(name = "ATTACHMENT_FILE_DELETE_YN")
    private String clientCbrDeleteYn;

    @Column(name = "ATTACHMENT_FILE_DIVISION")
    private String clientCbrDivision;

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "ATTACHMENT_FILE_CATEGORY_NO")
    private IssueAttachmentFileCategory issueAttachmentFileCategory;
}
