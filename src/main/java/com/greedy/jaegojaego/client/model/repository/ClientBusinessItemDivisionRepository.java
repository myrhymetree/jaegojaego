package com.greedy.jaegojaego.client.model.repository;

import com.greedy.jaegojaego.client.model.entity.ClientBusinessItem;
import com.greedy.jaegojaego.client.model.entity.ClientBusinessItemDivision;
import com.greedy.jaegojaego.client.model.entity.ClientBusinessItemDivisionPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientBusinessItemDivisionRepository extends JpaRepository<ClientBusinessItemDivision, ClientBusinessItemDivisionPK> {
}
