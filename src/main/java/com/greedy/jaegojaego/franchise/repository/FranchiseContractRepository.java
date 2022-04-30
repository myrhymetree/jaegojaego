package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseContractUpdatedRecord;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseContractRepository extends JpaRepository<FranchiseContractUpdatedRecord, Integer> {

}
