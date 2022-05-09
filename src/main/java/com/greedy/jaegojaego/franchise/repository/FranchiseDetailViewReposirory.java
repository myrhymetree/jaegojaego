package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseDetailView;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseDetailViewReposirory extends JpaRepository<FranchiseDetailView, Integer> {

    @EntityGraph(attributePaths = {"supervisor", "supervisor.department", "writer", "franchiseAttachmentFiles"}, type = EntityGraph.EntityGraphType.FETCH)
    FranchiseDetailView findByMemberNo(Integer franchiseNo);


}
