package com.greedy.jaegojaego.client.model.dto;

import com.greedy.jaegojaego.client.model.entity.ClientContractItem;
import com.greedy.jaegojaego.issue.attachement.model.dto.IssueAttachmentFileCategoryDTO;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDTO;
import lombok.Data;

@Data
public class ClientContractItemAttachmentFileDTO {

    private int attachmentFileNo;
    private String attachmentFileOriginalName;
    private String attachmentFileChangedName;
    private String attachmentFileUrl;
    private String attachmentFileDeleteYn;
    private String attachmentFileDivision;
    private ClientContractItem clientContractItem;
    private String attachmentFileThumbnailUrl;
}
