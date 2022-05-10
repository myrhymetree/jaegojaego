package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;

import java.util.List;

public interface FranchiseRepositoryCustom {
    void updateFranchise(FranchiseInfo franchise);
    List<FranchiseInfo> searchFranchise(String searchWord);
}
