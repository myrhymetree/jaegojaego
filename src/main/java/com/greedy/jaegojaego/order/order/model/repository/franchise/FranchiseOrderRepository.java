package com.greedy.jaegojaego.order.order.model.repository.franchise;

import com.greedy.jaegojaego.order.order.model.entitiy.franchise.FranchiseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FranchiseOrderRepository extends JpaRepository<FranchiseOrder, Integer> {
    List<FranchiseOrder> findByOrderFranchiseInfo_HeadOfficeSupervisor_MemberNo(int memberNo);

    List<FranchiseOrder> findByOrderFranchiseInfo_FranchiseRepresentativeNo(int memberNo);
}
