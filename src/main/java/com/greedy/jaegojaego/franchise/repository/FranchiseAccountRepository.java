package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.member.model.repository.CompanyAccountRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseAccountRepository extends JpaRepository<FranchiseAccount, Integer>, FranchiseAccountRepositoryCustom {

    FranchiseAccount findAllByMemberNoAndMemberDivisionAndOfficeDivision
            (Integer memberNo, String memberDivision, String officeDivision);

    FranchiseAccount findByMemberNo(Integer managerNo);
}
