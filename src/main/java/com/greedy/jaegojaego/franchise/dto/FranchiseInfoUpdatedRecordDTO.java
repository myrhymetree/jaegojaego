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
public class FranchiseInfoUpdatedRecordDTO {

    private Integer franchiseUpdatedInfoNo;
    private Integer infoWriteMemberNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime franchiseUpdatedDate;
    private Integer franchiseRepresentativeNo;

}
