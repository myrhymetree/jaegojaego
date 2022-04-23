package com.greedy.jaegojaego.client.model.repository;

import com.greedy.jaegojaego.client.model.entity.Client;
import com.greedy.jaegojaego.client.model.entity.ClientMemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientMemoRepository extends JpaRepository<ClientMemo, Integer> {

    List<ClientMemo> findByClientNo(int clientNo);

}
