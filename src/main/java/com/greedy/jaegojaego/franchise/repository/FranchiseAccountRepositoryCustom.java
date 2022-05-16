package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;

import java.util.List;

/**
 * <pre>
 * Class : FranchiseAccountRepositoryCustom
 * Comment : 가맹점 직원 계정 Spring-data JPA 공통 Repository의 사용자 정의형 Repository 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
public interface FranchiseAccountRepositoryCustom {

    /* 가맹점 직원 계정정보 수정 메소드 */
    void updateManager(FranchiseAccount manager);

    /* 검색어에 따른 가맹점 직원 계정 목록 조회 메소드 */
    List<FranchiseAccount> searchManager(String searchWord);

    /* 검색어에 따른 삭제된 가맹점 직원 계정 목록 조회 메소드 */
    List<FranchiseAccount> searchRemovedManager(String searchWord);
}
