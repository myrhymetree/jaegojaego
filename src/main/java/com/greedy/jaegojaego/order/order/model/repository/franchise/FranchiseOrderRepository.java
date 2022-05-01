package com.greedy.jaegojaego.order.order.model.repository.franchise;

import com.greedy.jaegojaego.order.order.model.entity.franchise.FranchiseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FranchiseOrderRepository extends JpaRepository<FranchiseOrder, Integer> {

    List<FranchiseOrder> findByMember_MemberNo(int memberNo);

    @Query(value = "SELECT FRANCHISE_ORDER_NO.CURRVAL " +
            "         FROM DUAL ", nativeQuery = true)
    int selectSequenceNo();
}
