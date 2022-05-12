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
public class ClientCbr {

    @Id
    @Column(name = "ATTACHMENT_FILE_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_CBR_SEQ_GENERATOR_SEQ_GENERATOR"
    )
    private int clientCbrAttachmentNo;

    @Column(name = "ATTACHMENT_FILE_ORIGINAL_NAME")
    private String clientCbrAttachmentOriginalName;

    @Column(name = "ATTACHMENT_FILE_CHANGED_NAME")
    private String clientCbrAttachmentChangedName;

    @Column(name = "ATTACHMENT_FILE_URL")
    private String clientCbrAttachmentUrl;

    @Column(name = "ATTACHMENT_FILE_DELETE_YN")
    private String clientCbrAttachmentDeleteYn;

    @Column(name = "ATTACHMENT_FILE_DIVISION")
    private String clientCbrAttachmentDivision;

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "ATTACHMENT_FILE_CATEGORY_NO")
    private IssueAttachmentFileCategory issueAttachmentFileCategory;



    public ClientCbr(int clientCbrAttachmentNo, String clientCbrAttachmentOriginalName, String clientCbrAttachmentChangedName, String clientCbrAttachmentUrl, String clientCbrAttachmentDeleteYn, String clientCbrAttachmentDivision, Client client, IssueAttachmentFileCategory issueAttachmentFileCategory) {
        this.clientCbrAttachmentNo = clientCbrAttachmentNo;
        this.clientCbrAttachmentOriginalName = clientCbrAttachmentOriginalName;
        this.clientCbrAttachmentChangedName = clientCbrAttachmentChangedName;
        this.clientCbrAttachmentUrl = clientCbrAttachmentUrl;
        this.clientCbrAttachmentDeleteYn = clientCbrAttachmentDeleteYn;
        this.clientCbrAttachmentDivision = clientCbrAttachmentDivision;
        this.client = client;
        this.issueAttachmentFileCategory = issueAttachmentFileCategory;
    }

    public ClientCbr() {

    }

    public int getClientCbrAttachmentNo() {
        return clientCbrAttachmentNo;
    }

    public void setClientCbrAttachmentNo(int clientCbrAttachmentNo) {
        this.clientCbrAttachmentNo = clientCbrAttachmentNo;
    }

    public String getClientCbrAttachmentOriginalName() {
        return clientCbrAttachmentOriginalName;
    }

    public void setClientCbrAttachmentOriginalName(String clientCbrAttachmentOriginalName) {
        this.clientCbrAttachmentOriginalName = clientCbrAttachmentOriginalName;
    }

    public String getClientCbrAttachmentChangedName() {
        return clientCbrAttachmentChangedName;
    }

    public void setClientCbrAttachmentChangedName(String clientCbrAttachmentChangedName) {
        this.clientCbrAttachmentChangedName = clientCbrAttachmentChangedName;
    }

    public String getClientCbrAttachmentUrl() {
        return clientCbrAttachmentUrl;
    }

    public void setClientCbrAttachmentUrl(String clientCbrAttachmentUrl) {
        this.clientCbrAttachmentUrl = clientCbrAttachmentUrl;
    }

    public String getClientCbrAttachmentDeleteYn() {
        return clientCbrAttachmentDeleteYn;
    }

    public void setClientCbrAttachmentDeleteYn(String clientCbrAttachmentDeleteYn) {
        this.clientCbrAttachmentDeleteYn = clientCbrAttachmentDeleteYn;
    }

    public String getClientCbrAttachmentDivision() {
        return clientCbrAttachmentDivision;
    }

    public void setClientCbrAttachmentDivision(String clientCbrAttachmentDivision) {
        this.clientCbrAttachmentDivision = clientCbrAttachmentDivision;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public IssueAttachmentFileCategory getIssueAttachmentFileCategory() {
        return issueAttachmentFileCategory;
    }

    public void setIssueAttachmentFileCategory(IssueAttachmentFileCategory issueAttachmentFileCategory) {
        this.issueAttachmentFileCategory = issueAttachmentFileCategory;
    }

    @Override
    public String toString() {
        return "ClientCbr{" +
                "clientCbrAttachmentNo=" + clientCbrAttachmentNo +
                ", clientCbrAttachmentOriginalName='" + clientCbrAttachmentOriginalName + '\'' +
                ", clientCbrAttachmentChangedName='" + clientCbrAttachmentChangedName + '\'' +
                ", clientCbrAttachmentUrl='" + clientCbrAttachmentUrl + '\'' +
                ", clientCbrAttachmentDeleteYn='" + clientCbrAttachmentDeleteYn + '\'' +
                ", clientCbrAttachmentDivision='" + clientCbrAttachmentDivision + '\'' +
                ", issueAttachmentFileCategory=" + issueAttachmentFileCategory +
                '}';
    }
}
