package com.greedy.jaegojaego.order.franchise.model.repository;

import com.greedy.jaegojaego.order.franchise.model.entity.OrderFranchiseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderFranchiseInfoRepository extends JpaRepository<OrderFranchiseInfo, Integer> {


    List<OrderFranchiseInfo> findByHeadOfficeSupervisor_MemberNo(int memberNo);
}
