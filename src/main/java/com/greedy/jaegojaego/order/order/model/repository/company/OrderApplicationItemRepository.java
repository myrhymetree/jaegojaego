package com.greedy.jaegojaego.order.order.model.repository.company;

import com.greedy.jaegojaego.order.order.model.entitiy.company.OrderApplicationItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderApplicationItemRepository extends JpaRepository<OrderApplicationItem, Integer> {
}