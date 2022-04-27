package com.greedy.jaegojaego.order.order.model.repository;

import com.greedy.jaegojaego.order.warehouse.entity.entitiy.CompanyOrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyOrderHistoryRepository extends JpaRepository<CompanyOrderHistory, Integer> {

}
