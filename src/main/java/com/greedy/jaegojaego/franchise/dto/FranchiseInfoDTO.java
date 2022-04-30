package com.greedy.jaegojaego.franchise.dto;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FranchiseInfoDTO extends MemberDTO {

    private String representativeName;
    private String representativePhone;
    private String representativeEmail;
    private String branchName;
    private String businessRegistrationNo;
    private String address;
    private String bankAccountNo;
    private Integer supervisorNo;
    private Integer writedMemberNo;
    private String phone;
    private Integer headOfficeWritedMemberNo;
    private Member supervisor;
    private Member writedMember;
    private List<FranchiseAttachmentFileDTO> franchiseAttachmentFiles;
    private List<FranchiseContractUpdatedRecordDTO> franchiseContractUpdatedRecords;
    private List<FranchiseInfoUpdatedRecordDTO> franchiseInfoUpdatedRecords;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime franchiseContractStartedDate;
//    @DateTimeFormat(pattern = "MM-dd-yyyy")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime franchiseContractExpiredDate;
    private String franchiseContractStatus;
}
