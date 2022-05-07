package com.greedy.jaegojaego.issue.franchise.model.repository;

import com.greedy.jaegojaego.issue.franchise.model.entity.IssueFranchiseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueFranchiseInfoRepository extends JpaRepository<IssueFranchiseInfo, Integer> {


    List<IssueFranchiseInfo> findByHeadOfficeSupervisor_MemberNo(int memberNo);
}
