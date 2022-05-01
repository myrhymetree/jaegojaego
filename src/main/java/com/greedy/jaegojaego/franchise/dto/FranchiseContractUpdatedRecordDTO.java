package com.greedy.jaegojaego.franchise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FranchiseContractUpdatedRecordDTO {

    private Integer franchiseContractUpdateNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime franchiseContractStartedDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime franchiseContractExpiredDate;
    private String franchiseContractStatus;
    private Integer franchiseRepresentativeNo;
}
