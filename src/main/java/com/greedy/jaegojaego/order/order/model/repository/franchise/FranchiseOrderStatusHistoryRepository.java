package com.greedy.jaegojaego.order.order.model.repository.franchise;

import com.greedy.jaegojaego.order.order.model.entity.franchise.FranchiseOrderStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FranchiseOrderStatusHistoryRepository extends JpaRepository<FranchiseOrderStatusHistory, Integer> {

    List<FranchiseOrderStatusHistory> findByFranchiseOrderNo(int franchiseOrderNo);
}
