package com.greedy.jaegojaego.client.model.repository;

import com.greedy.jaegojaego.client.model.entity.Client;
import com.greedy.jaegojaego.client.model.entity.ClientContractInfo;
import com.greedy.jaegojaego.client.model.entity.ClientContractItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientContractItemRepository extends JpaRepository<ClientContractItem, Integer> {

    @Query(value = "SELECT * "+
    "               FROM CLIENT_CONTRACT_ITEM A" +
    "               JOIN CLIENT_CONTRACT_INFO B ON(A.CLIENT_CONTRACT_INFO_NO = B.CLIENT_CONTRACT_INFO_NO)" +
    "               JOIN CLIENT C ON(B.CLIENT_NO = C.CLIENT_NO)"
                    , nativeQuery = true
    )
    Page<ClientContractItem> findAll(Pageable pageable);

    @Query(value = "SELECT *" +
    "               FROM CLIENT_CONTRACT_ITEM A" +
    "               JOIN CLIENT_CONTRACT_INFO B ON (A.CLIENT_CONTRACT_INFO_NO = B.CLIENCT_CONTRACT_INFO_NO)" +
    "               JOIN CLIENT C ON(B.CLIENT_NO = C.CLIENT_NO)" +
    "               WHERE C.CLIENT_NO = ?1", nativeQuery = true
    )
    ClientContractInfo findByClient(int clientNo);
}
