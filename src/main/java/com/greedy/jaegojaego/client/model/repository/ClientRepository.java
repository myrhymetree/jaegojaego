package com.greedy.jaegojaego.client.model.repository;

import com.greedy.jaegojaego.client.model.entity.Client;
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
/*
    Page<Client> findByClientNameContainingAnyTypeAndStatus(String searchValue, Integer integer, String y, Pageable pageable);

    Page<Client> findByClientRepresentativeNameContainingTypeAndStatus(String searchValue, Integer integer, String y, Pageable pageable);
*/



}
