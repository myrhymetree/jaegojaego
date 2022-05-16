package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.member.model.repository.CompanyAccountRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : FranchiseAccountRepository
 * Comment : 가맹점 직원 계정 Spring-data JPA 공통 레포지토리 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Repository
public interface FranchiseAccountRepository extends JpaRepository<FranchiseAccount, Integer>, FranchiseAccountRepositoryCustom {

    /* 가맹점과 직원 여부에 따라서 계정 정보를 조회하는 메소드 */
    FranchiseAccount findAllByMemberNoAndMemberDivisionAndOfficeDivision(Integer memberNo, String memberDivision, String officeDivision);

    /* 계정번호로 직원 정보를 조회하는 메소드 */
    FranchiseAccount findByMemberNo(Integer managerNo);
}
