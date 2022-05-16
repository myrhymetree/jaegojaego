package com.greedy.jaegojaego.member.model.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyAccountDTO extends MemberDTO {

    private String memberName;
    private String memberEmail;
    private String memberCellPhone;
    private String officePhoneNumber;
    private Integer departmentNo;
    private DepartmentDTO department;
    private String companyAddress;

    @QueryProjection
    public CompanyAccountDTO(Integer memberNo, String memberId, String memberPwd, LocalDateTime memberPwdUpdateDate, String memberPwdInitStatus, LocalDateTime memberCreatedDate, LocalDateTime memberRemovedDate, String memberRemoveStatus, String officeDivision, String memberDivision, CompanyAccountDTO companyAccountDTO, List<AuthorityDTO> authorityDTOList, String memberName, String memberEmail, String memberCellPhone, String companyAddress, String officePhoneNumber, Integer departmentNo, DepartmentDTO department) {
        super(memberNo, memberId, memberPwd, memberPwdUpdateDate, memberPwdInitStatus, memberCreatedDate, memberRemovedDate, memberRemoveStatus, officeDivision, memberDivision, companyAccountDTO, authorityDTOList);
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberCellPhone = memberCellPhone;
        this.officePhoneNumber = officePhoneNumber;
        this.departmentNo = departmentNo;
        this.department = department;
        this.companyAddress = companyAddress;

    }

    @Override
    public String toString() {
        return "CompanyAccountDTO{" +
                "memberNo=" + super.getMemberNo() +
                ", memberId=" + super.getMemberId() +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberCellPhone='" + memberCellPhone + '\'' +
                ", officePhoneNumber='" + officePhoneNumber + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", department=" + department +
                '}';
    }
}
