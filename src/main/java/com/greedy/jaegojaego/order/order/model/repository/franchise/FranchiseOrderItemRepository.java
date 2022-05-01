package com.greedy.jaegojaego.order.order.model.repository.franchise;

import com.greedy.jaegojaego.order.order.model.entity.franchise.FranchiseOrderItem;
import com.greedy.jaegojaego.order.order.model.entity.franchise.FranchiseOrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseOrderItemRepository extends JpaRepository<FranchiseOrderItem, FranchiseOrderItemPK> {
}
