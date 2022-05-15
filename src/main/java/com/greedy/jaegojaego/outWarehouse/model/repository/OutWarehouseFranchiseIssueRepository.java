package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : OutWarehouseFranchiseIssueRepository
 * Comment : 가맹점 이슈 목록 조회 로직을 처리하기 위한 메소드를 모아둔 Repository입니다.
 * History
 * 2022/05/14 (이태준) 가맹점 이슈 목록 조회 로직
 * </pre>
 * @version 1.0
 * @author 이태준
 * */
@Repository
public interface OutWarehouseFranchiseIssueRepository extends JpaRepository<OutWarehouseFranchiseIssue, Integer> {

    /**
     * findByFranchiseIssueStatus : 이슈 처리상태에 따른 가맹점 이슈 목록 리스트 조회
     * @param status : 이슈 처리상태
     * @return : 가맹점 이슈 목록 리스트
     */
    List<OutWarehouseFranchiseIssue> findByFranchiseIssueStatus(String status);

    /**
     * findByFranchiseIssueNo : 이슈번호에 따른 가맹점 이슈 목록 조회
     * @param franchiseIssueNo : 이슈번호
     * @return : 가맹점 이슈 목록
     */
    OutWarehouseFranchiseIssue findByFranchiseIssueNo(int franchiseIssueNo);
}
