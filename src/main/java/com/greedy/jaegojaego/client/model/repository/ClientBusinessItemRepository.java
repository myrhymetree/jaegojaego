package com.greedy.jaegojaego.client.model.repository;

import com.greedy.jaegojaego.client.model.entity.ClientBusinessItem;
import com.greedy.jaegojaego.client.model.entity.ClientBusinessType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientBusinessItemRepository extends JpaRepository<ClientBusinessItem, Integer> {

}
