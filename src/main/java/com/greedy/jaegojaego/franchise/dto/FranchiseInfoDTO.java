package com.greedy.jaegojaego.franchise.dto;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URLEncoder;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FranchiseInfoDTO extends MemberDTO {

    private String representativeName;
    private String representativePhone;
    private String representativeEmail;
    private String branchName;
    private String businessRegistrationNo;
    private String address;
    private String bankAccountNo;
    private Member supervisorNo;
    private Member writedMemberNo;
    private String phone;
    private Integer headOfficeWritedMemberNo;
    private List<FranchiseAttachmentFileDTO> franchiseAttachmentFiles;
    private List<FranchiseContractUpdatedRecordDTO> franchiseContractUpdatedRecords;
    private List<FranchiseInfoUpdatedRecordDTO> franchiseInfoUpdatedRecords;



}
