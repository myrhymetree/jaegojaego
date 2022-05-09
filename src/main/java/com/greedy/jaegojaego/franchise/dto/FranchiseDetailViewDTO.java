package com.greedy.jaegojaego.franchise.dto;

import com.greedy.jaegojaego.franchise.entity.FranchiseAttachmentFile;
import com.greedy.jaegojaego.franchise.entity.FranchiseContractUpdatedRecord;
import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FranchiseDetailViewDTO extends MemberDTO {

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
    private CompanyAccountDTO supervisor;
    private CompanyAccountDTO writer;
    private List<FranchiseAttachmentFileDTO> franchiseAttachmentFiles;
    private FranchiseContractUpdatedRecordDTO franchiseContractUpdatedRecord;

    @Override
    public String toString() {
        return "FranchiseDetailViewDTO{" +
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
                ", supervisor=" + supervisor +
                ", writer=" + writer +
                ", franchiseAttachmentFiles=" + franchiseAttachmentFiles +
                ", franchiseContractUpdatedRecord=" + franchiseContractUpdatedRecord +
                '}';
    }
}
