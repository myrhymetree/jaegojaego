package com.greedy.jaegojaego.order.franchise.model.repository;

import com.greedy.jaegojaego.order.franchise.model.entity.OrderFranchiseAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderFranchiseAccountRepository extends JpaRepository<OrderFranchiseAccount, Integer> {

    List<OrderFranchiseAccount> findByFranchiseInfo_FranchiseRepresentativeNo(int representativeNo);
}
