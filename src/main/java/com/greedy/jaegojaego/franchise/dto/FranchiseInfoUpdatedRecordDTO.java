package com.greedy.jaegojaego.franchise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FranchiseInfoUpdatedRecordDTO {

    private Integer franchiseUpdatedInfoNo;
    private Integer infoWriteMemberNo;
    private Integer franchiseUpdatedDate;
    private Integer franchiseRepresentativeNo;

}
