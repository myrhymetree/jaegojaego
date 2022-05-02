package com.greedy.jaegojaego.member.model.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CompanyAccountDTO extends NewMemberDTO {

    private String memberName;
    private String memberEmail;
    private String memberCellPhone;
    private String officePhoneNumber;

    private DepartmentDTO department;

    @QueryProjection
    public CompanyAccountDTO(Integer memberNo, String memberId, String memberPwd, LocalDateTime memberPwdUpdateDate, String memberPwdInitStatus, LocalDateTime memberCreatedDate, LocalDateTime memberRemovedDate, String memberRemoveStatus, String officeDivision, String memberDivision, CompanyAccountDTO companyAccountDTO, List<AuthorityDTO> authorityDTOList, Integer memberNo1, String memberName, String memberEmail, String memberCellPhone, String officePhoneNumber, DepartmentDTO department) {
        super(memberNo, memberId, memberPwd, memberPwdUpdateDate, memberPwdInitStatus, memberCreatedDate, memberRemovedDate, memberRemoveStatus, officeDivision, memberDivision, companyAccountDTO, authorityDTOList);
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberCellPhone = memberCellPhone;
        this.officePhoneNumber = officePhoneNumber;
        this.department = department;
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
                ", department=" + department +
                '}';
    }
}
