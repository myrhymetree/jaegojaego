package com.greedy.jaegojaego.client.model.repository;

import com.greedy.jaegojaego.client.model.entity.ClientBusinessItemDivision;
import com.greedy.jaegojaego.client.model.entity.ClientBusinessItemDivisionPK;
import com.greedy.jaegojaego.client.model.entity.ClientBusinessTypeDivision;
import com.greedy.jaegojaego.client.model.entity.ClientBusinessTypeDivisionPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientBusinessTypeDivisionRepository extends JpaRepository<ClientBusinessTypeDivision, ClientBusinessTypeDivisionPK> {
}
