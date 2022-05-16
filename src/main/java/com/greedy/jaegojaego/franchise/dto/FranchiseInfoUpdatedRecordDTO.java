package com.greedy.jaegojaego.franchise.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FranchiseInfoUpdatedRecordDTO {

    private Integer franchiseUpdatedInfoNo;
    private Integer infoWriteMemberNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime franchiseUpdatedDate;
    private Integer franchiseRepresentativeNo;


}
