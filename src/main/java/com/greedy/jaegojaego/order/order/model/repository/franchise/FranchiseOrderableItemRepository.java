package com.greedy.jaegojaego.order.order.model.repository.franchise;

import com.greedy.jaegojaego.order.order.model.entity.franchise.FranchiseOrderableItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FranchiseOrderableItemRepository extends JpaRepository<FranchiseOrderableItem, Integer> {

    List<FranchiseOrderableItem> findByFranchiseOrderableItem_OrderItemInfo_ItemInfoStatusYn(String deleteYn);
}
