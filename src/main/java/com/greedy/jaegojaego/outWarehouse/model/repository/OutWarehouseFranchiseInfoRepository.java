package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseInfo;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseInfoPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : OutWarehouseFranchiseInfoRepository
 * Comment : 가맹점 정보 조회 로직을 처리하기 위한 메소드를 모아둔 Repository입니다.
 * History
 * 2022/05/01 (이태준) 가맹점 정보 조회 로직
 * 2022/05/02 (이태준) 가맹점 발주 신청자가 대표자일 때 가맹점 정보 조회 로직 재작성
 * 2022/05/04 (이태준) 가맹점 발주 신청자가 직원일 때 가맹점 정보 조회 로직
 * </pre>
 * @version 1.1
 * @author 이태준
 * */
@Repository
public interface OutWarehouseFranchiseInfoRepository extends JpaRepository<OutWarehouseFranchiseInfo, Integer> {

    /**
     * getFranchiseInfo : 가맹점 발주 신청자가 대표자일 때 가맹점 정보 조회
     * @param pkParam : 가맹점 정보 엔티티 식별자
     * @return 가맹점 정보
     */
    @Query(value = "SELECT a " +
            "         FROM outWarehouseFranchiseInfo a " +
            "        WHERE a.franchiseRepresentativeNo = :pkParam")
    OutWarehouseFranchiseInfo getFranchiseInfo(OutWarehouseFranchiseInfoPk pkParam);

    /**
     * findByFranchiseRepresentativeNo : 가맹점 발주 신청자가 직원일 때 가맹점 정보 조회
     * @param franchiseRepresentativeNo : 해당 가맹점 대표자 번호
     * @return 가맹점 정보
     */
    OutWarehouseFranchiseInfo findByFranchiseRepresentativeNo(OutWarehouseFranchiseInfoPk franchiseRepresentativeNo);
}
