package com.greedy.jaegojaego.client.model.dto;

import com.greedy.jaegojaego.client.model.entity.Client;
import com.greedy.jaegojaego.client.model.entity.ClientContractItem;
import com.greedy.jaegojaego.issue.attachement.model.entity.IssueAttachmentFileCategory;
import lombok.Data;

public class ClientCbrDTO {

    private int clientCbrAttachmentNo;
    private String clientCbrAttachmentOriginalName;
    private String clientCbrAttachmentchangedName;
    private String clientCbrAttachmentFileUrl;
    private String clientCbrAttachmentFileDeleteYn;
    private String clientCbrAttachmentFileDivision;
    private ClientDTO client;
    private IssueAttachmentFileCategory issueAttachmentFileCategory;

    public ClientCbrDTO(){}

    public ClientCbrDTO(int clientCbrAttachmentNo, String clientCbrAttachmentOriginalName, String clientCbrAttachmentchangedName, String clientCbrAttachmentFileUrl, String clientCbrAttachmentFileDeleteYn, String clientCbrAttachmentFileDivision, ClientDTO client, IssueAttachmentFileCategory issueAttachmentFileCategory) {
        this.clientCbrAttachmentNo = clientCbrAttachmentNo;
        this.clientCbrAttachmentOriginalName = clientCbrAttachmentOriginalName;
        this.clientCbrAttachmentchangedName = clientCbrAttachmentchangedName;
        this.clientCbrAttachmentFileUrl = clientCbrAttachmentFileUrl;
        this.clientCbrAttachmentFileDeleteYn = clientCbrAttachmentFileDeleteYn;
        this.clientCbrAttachmentFileDivision = clientCbrAttachmentFileDivision;
        this.client = client;
        this.issueAttachmentFileCategory = issueAttachmentFileCategory;
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

    public String getClientCbrAttachmentchangedName() {
        return clientCbrAttachmentchangedName;
    }

    public void setClientCbrAttachmentchangedName(String clientCbrAttachmentchangedName) {
        this.clientCbrAttachmentchangedName = clientCbrAttachmentchangedName;
    }

    public String getClientCbrAttachmentFileUrl() {
        return clientCbrAttachmentFileUrl;
    }

    public void setClientCbrAttachmentFileUrl(String clientCbrAttachmentFileUrl) {
        this.clientCbrAttachmentFileUrl = clientCbrAttachmentFileUrl;
    }

    public String getClientCbrAttachmentFileDeleteYn() {
        return clientCbrAttachmentFileDeleteYn;
    }

    public void setClientCbrAttachmentFileDeleteYn(String clientCbrAttachmentFileDeleteYn) {
        this.clientCbrAttachmentFileDeleteYn = clientCbrAttachmentFileDeleteYn;
    }

    public String getClientCbrAttachmentFileDivision() {
        return clientCbrAttachmentFileDivision;
    }

    public void setClientCbrAttachmentFileDivision(String clientCbrAttachmentFileDivision) {
        this.clientCbrAttachmentFileDivision = clientCbrAttachmentFileDivision;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
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
        return "ClientCbrDTO{" +
                "clientCbrAttachmentNo=" + clientCbrAttachmentNo +
                ", clientCbrAttachmentOriginalName='" + clientCbrAttachmentOriginalName + '\'' +
                ", clientCbrAttachmentchangedName='" + clientCbrAttachmentchangedName + '\'' +
                ", clientCbrAttachmentFileUrl='" + clientCbrAttachmentFileUrl + '\'' +
                ", clientCbrAttachmentFileDeleteYn='" + clientCbrAttachmentFileDeleteYn + '\'' +
                ", clientCbrAttachmentFileDivision='" + clientCbrAttachmentFileDivision + '\'' +
                ", issueAttachmentFileCategory=" + issueAttachmentFileCategory +
                '}';
    }
}
