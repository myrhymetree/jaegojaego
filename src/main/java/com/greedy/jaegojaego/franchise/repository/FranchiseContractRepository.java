package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseContractUpdatedRecord;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : FranchiseContractRepository
 * Comment : 가맹점 계약관련 정보 Spring-data JPA 공통 레포지토리 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Repository
public interface FranchiseContractRepository extends JpaRepository<FranchiseContractUpdatedRecord, Integer> {

    /* 가장 최근에 갱신된 가맹점 계약정보를 조회하는 메소드 */
    @Query("select c from FranchiseContractUpdatedRecord c where c.franchiseRepresentativeNo = :memberNo " +
    "and c.franchiseContractStartedDate = (select max (b.franchiseContractStartedDate) from FranchiseContractUpdatedRecord b where b.franchiseRepresentativeNo = :memberNo)")
    FranchiseContractUpdatedRecord findByFranchiseRepresentativeNo(@Param("memberNo") Integer memberNo);

}
