package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;

import java.util.List;

public interface FranchiseAccountRepositoryCustom {

    void updateManager(FranchiseAccount manager);

    List<FranchiseAccount> searchManager(String searchWord);
}
