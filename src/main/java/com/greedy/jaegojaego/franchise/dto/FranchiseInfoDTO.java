package com.greedy.jaegojaego.franchise.dto;

import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import com.greedy.jaegojaego.member.model.entity.Member;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    private CompanyAccountDTO supervisor;
    private MemberDTO writedMember;
    private List<FranchiseAttachmentFileDTO> franchiseAttachmentFiles;
    private List<FranchiseContractUpdatedRecordDTO> franchiseContractUpdatedRecords;
    private List<FranchiseInfoUpdatedRecordDTO> franchiseInfoUpdatedRecords;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime franchiseContractStartedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime franchiseContractExpiredDate;
    private String franchiseContractStatus;

    @Override
    public String toString() {
        return "FranchiseInfoDTO{" +
                "representativeName='" + representativeName + '\'' +
                ", representativePhone='" + representativePhone + '\'' +
                ", representativeEmail='" + representativeEmail + '\'' +
                ", branchName='" + branchName + '\'' +
                ", businessRegistrationNo='" + businessRegistrationNo + '\'' +
                ", address='" + address + '\'' +
                ", bankAccountNo='" + bankAccountNo + '\'' +
                ", supervisorNo=" + supervisorNo +
                ", writedMemberNo=" + writedMemberNo +
                ", phone='" + phone + '\'' +
                ", headOfficeWritedMemberNo=" + headOfficeWritedMemberNo +
                ", supervisor=" + supervisor +
                ", writedMember=" + writedMember +
                ", franchiseAttachmentFiles=" + franchiseAttachmentFiles +
                ", franchiseContractUpdatedRecords=" + franchiseContractUpdatedRecords +
                ", franchiseInfoUpdatedRecords=" + franchiseInfoUpdatedRecords +
                ", franchiseContractStartedDate=" + franchiseContractStartedDate +
                ", franchiseContractExpiredDate=" + franchiseContractExpiredDate +
                ", franchiseContractStatus='" + franchiseContractStatus + '\'' +
                '}';
    }
}
