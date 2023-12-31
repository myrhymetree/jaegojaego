package com.greedy.jaegojaego.client.model.repository;

import com.greedy.jaegojaego.client.model.dto.ClientDetailDTO;
import com.greedy.jaegojaego.client.model.entity.Client;
import org.hibernate.query.NativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Page<Client> findAll(Pageable pageable);
    int findClientNoByClientName(String clientName);

    Client findByClientName(String clientName);

    Client findByClientNo(int clientNo);
}
