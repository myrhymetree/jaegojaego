package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.entity.CompanyAccount;

import java.util.List;

/**
 * <pre>
 * Class : CompanyAccountRepositoryCustom
 * Comment : 본사 직원 계정 Spring-data JPA 공통 Repository의 사용자 정의형 Repository 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
public interface CompanyAccountRepositoryCustom {

    /* 본사 직원 계정정보 수정 메소드 */
    void updateMember(CompanyAccount member);

    /* 검색어에 따른 본사 직원 계정 목록 조회 메소드  */
    List<CompanyAccount> searchMembers(String searchWord);

    /* 검색어에 따른 삭제된 본사 직원 계정 목록 조회 메소드 */
    List<CompanyAccount> searchRemovedMember(String searchWord);
}
