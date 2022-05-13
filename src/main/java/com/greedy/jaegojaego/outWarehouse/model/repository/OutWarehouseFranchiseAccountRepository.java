package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseAccount;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseAccountPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : OutWarehouseFranchiseAccountRepository
 * Comment : 발주 요청자가 가맹점 직원일 때 가맹점의 정보를 조회하기 위한 로직을 처리하는 메소드를 모아둔 Repository입니다.
 * History
 * 2022/05/01 (이태준) 가맹점 정보 조회 로직
 * 2022/05/02 (이태준) 테이블 수정 및 쿼리문 수정
 * 2022/05/05 (이태준) 가맹점 정보 조회 로직 마무리
 * </pre>
 * @version 1.3
 * @author 이태준
 * */
@Repository
public interface OutWarehouseFranchiseAccountRepository extends JpaRepository<OutWarehouseFranchiseAccount, Integer> {

    /**
     * getRepresentativeNo : 해당 가맹점 정보 조회
     * @param accountPkParam : 가맹점 직원 계정 테이블 pk 정보
     * @return : 해당 가맹점 정보
     */
    @Query(value = "SELECT a FROM outWarehouseFranchiseAccount a WHERE a.franchiseManagerNo = :accountPkParam")
    OutWarehouseFranchiseAccount getRepresentativeNo(OutWarehouseFranchiseAccountPk accountPkParam);
}
