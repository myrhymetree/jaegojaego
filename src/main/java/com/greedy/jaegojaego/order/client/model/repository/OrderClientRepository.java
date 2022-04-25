package com.greedy.jaegojaego.order.client.model.repository;

import com.greedy.jaegojaego.order.client.model.entity.OrderClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderClientRepository extends JpaRepository<OrderClient, Integer> {
}
