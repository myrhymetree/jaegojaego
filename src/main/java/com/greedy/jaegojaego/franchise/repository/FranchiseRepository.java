package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseDetailView;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : FranchiseRepository
 * Comment : 가맹점 계정 Spring-data JPA 공통 레포지토리 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Repository
public interface FranchiseRepository extends JpaRepository<FranchiseInfo, Integer>, FranchiseRepositoryCustom {

    /* 가맹점과 대표자 여부에 따라서 해당 정보를 조회하는 메소드 */
    FranchiseInfo findAllByMemberNoAndMemberDivisionAndOfficeDivision(Integer memberNo, String memberDivision, String officeDivision);

    /* 가맹점 대표자 계정 정보 조회 메소드,
     * fetchJoin을 통해서 연관된 첨부파일 정보를 한꺼번에 즉시로딩으로 출력한다.
     */
    @EntityGraph( attributePaths = { "franchiseAttachmentFiles" }, type = EntityGraph.EntityGraphType.FETCH)
    FranchiseInfo findByMemberNo(Integer memberNo);

}
