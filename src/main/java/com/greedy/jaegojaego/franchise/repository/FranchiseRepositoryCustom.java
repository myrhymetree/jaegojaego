package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;

import java.util.List;

/**
 * <pre>
 * Class : FranchiseRepositoryCustom
 * Comment : 가맹점 대표자 계정 Spring-data JPA 공통 Repository의 사용자 정의형 Repository 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
public interface FranchiseRepositoryCustom {

    /* 가맹점 대표자 계정정보 수정 메소드 */
    FranchiseInfo updateFranchise(FranchiseInfo franchise);

    /* 검색어에 따른 가맹점 대표자 계정 목록 조회 메소드 */
    List<FranchiseInfo> searchFranchise(String searchWord);

    /* 검색어에 따른 삭제된 가맹점 대표자 계정 목록 조회 메소드 */
    List<FranchiseInfo> searchRemovedFranchise(String searchWord);
}
