package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseDetailView;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<FranchiseInfo, Integer>, FranchiseRepositoryCustom {

    FranchiseInfo  findAllByMemberNoAndMemberDivisionAndOfficeDivision
            (Integer memberNo, String memberDivision, String officeDivision);

    @EntityGraph( attributePaths = { "franchiseAttachmentFiles" }, type = EntityGraph.EntityGraphType.FETCH)
    FranchiseInfo findByMemberNo(Integer memberNo);
}
