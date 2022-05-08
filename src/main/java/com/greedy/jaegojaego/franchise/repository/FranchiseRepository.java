package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<FranchiseInfo, Integer>, FranchiseRepositoryCustom {

    FranchiseInfo  findAllByMemberNoAndMemberDivisionAndOfficeDivision
            (Integer memberNo, String memberDivision, String officeDivision);

    FranchiseInfo findByMemberNo(Integer franchiseNo);
}
