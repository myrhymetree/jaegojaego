package com.greedy.jaegojaego.franchise.dto;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class FranchiseAccountDTO extends MemberDTO {

    private Integer managerNo;

    private String menagerName;

    private String menagerPhone;

    private String managerEmail;

    private Integer representativeNo;

}
