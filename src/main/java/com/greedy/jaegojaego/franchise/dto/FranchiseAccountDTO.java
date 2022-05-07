package com.greedy.jaegojaego.franchise.dto;

import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class FranchiseAccountDTO extends MemberDTO {

    private String managerName;
    private String managerPhone;
    private String managerEmail;
    private Integer representativeNo;

    private FranchiseInfoDTO franchiseInfo;

}
