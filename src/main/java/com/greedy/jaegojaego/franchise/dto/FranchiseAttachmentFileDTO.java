package com.greedy.jaegojaego.franchise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URLEncoder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FranchiseAttachmentFileDTO {

    private Integer attachmentNo;
    private String attachmentFileOriginalName;
    private String attachmentFileChangedName;
    private String attachmentFileURL;
    private String attachmentFileDeleteYn;
    private Integer attachmentFileCategoryNo;
    private String attachmentFileDivision;
    private Integer franchiseRepresentativeNo;
    private Integer franchiseContractUpdateNo;

}
