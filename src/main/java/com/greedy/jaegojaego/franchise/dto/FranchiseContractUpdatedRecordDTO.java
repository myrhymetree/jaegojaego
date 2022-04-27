package com.greedy.jaegojaego.franchise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FranchiseContractUpdatedRecordDTO {

    private Integer franchiseContractUpdateNo;
    private LocalDateTime franchiseContractStartedDate;
    private LocalDateTime franchiseContractExpiredDate;
    private String franchiseContractStatus;
    private Integer franchiseRepresentativeNo;
}
