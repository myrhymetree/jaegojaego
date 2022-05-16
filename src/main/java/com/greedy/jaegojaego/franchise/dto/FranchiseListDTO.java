package com.greedy.jaegojaego.franchise.dto;

import com.greedy.jaegojaego.franchise.dto.FranchiseInfoDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FranchiseListDTO {

    private List<FranchiseInfoDTO> franchiseList;
    private List<FranchiseInfoDTO> removedFranchiseList;
    private List<FranchiseAccountDTO> managerList;
    private List<FranchiseAccountDTO> removedManagerList;

}
