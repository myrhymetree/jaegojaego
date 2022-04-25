package com.greedy.jaegojaego.order.order.model.repository.company;

import com.greedy.jaegojaego.order.order.model.entitiy.company.CompanyOrderItem;
import com.greedy.jaegojaego.order.order.model.entitiy.company.CompanyOrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyOrderItemRepository extends JpaRepository<CompanyOrderItem, CompanyOrderItemPK> {

}
