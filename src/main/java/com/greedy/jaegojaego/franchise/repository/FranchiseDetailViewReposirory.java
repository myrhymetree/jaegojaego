package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseDetailView;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : FranchiseDetailViewReposirory
 * Comment : 가맹점 대표자 상세정보 Spring-data JPA 공통 레포지토리 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Repository
public interface FranchiseDetailViewReposirory extends JpaRepository<FranchiseDetailView, Integer> {

    /* 가맹점 대표자 상세정보 조회 메소드 */
    @EntityGraph(attributePaths = {"supervisor", "supervisor.department", "writer", "franchiseAttachmentFiles"}, type = EntityGraph.EntityGraphType.FETCH)
    FranchiseDetailView findByMemberNo(Integer franchiseNo);


}
