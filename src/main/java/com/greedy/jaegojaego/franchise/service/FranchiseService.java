package com.greedy.jaegojaego.franchise.service;

import com.greedy.jaegojaego.franchise.dto.FranchiseInfoDTO;
import com.greedy.jaegojaego.franchise.repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranchiseService {

    private final FranchiseRepository franchiseReopsitory;

    @Autowired
    public FranchiseService(FranchiseRepository franchiseReopsitory) {
        this.franchiseReopsitory = franchiseReopsitory;
    }

    public void registFranchise(FranchiseInfoDTO franchiseInfo) {


    }
}
