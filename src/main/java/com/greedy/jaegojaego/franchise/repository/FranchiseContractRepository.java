package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseContractUpdatedRecord;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FranchiseContractRepository extends JpaRepository<FranchiseContractUpdatedRecord, Integer> {

    @Query("select c from FranchiseContractUpdatedRecord c where c.franchiseRepresentativeNo = :memberNo " +
    "and c.franchiseContractStartedDate = (select max (b.franchiseContractStartedDate) from FranchiseContractUpdatedRecord b)")
    FranchiseContractUpdatedRecord findByFranchiseRepresentativeNo(@Param("memberNo") Integer memberNo);

}
