package com.greedy.jaegojaego.issue.franchise.model.repository;

import com.greedy.jaegojaego.issue.franchise.model.entity.IssueFranchiseAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueFranchiseAccountRepository extends JpaRepository<IssueFranchiseAccount, Integer> {

    List<IssueFranchiseAccount> findByFranchiseInfo_FranchiseRepresentativeNo(Integer franchiseRepresentativeNo);
}
