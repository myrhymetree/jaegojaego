package com.greedy.jaegojaego.order.order.model.repository.franchise;

import com.greedy.jaegojaego.order.order.model.entity.franchise.FranchiseOrderableItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseOrderableItemRepository extends JpaRepository<FranchiseOrderableItem, Integer> {
}
