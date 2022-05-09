package com.greedy.jaegojaego.client.model.repository;

import com.greedy.jaegojaego.client.model.entity.ClientContractInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientContractInfoRepository extends JpaRepository<ClientContractInfo, Integer> {

    @Query(value = "SELECT * " +
    "               FROM Client_Contract_Info A" +
    "               JOIN Client B ON(A.CLIENT_NO = B.CLIENT_NO)"+
    "               WHERE B.CLIENT_NO = ?1" , nativeQuery = true)
    List<ClientContractInfo> findByClient(int clientNo);
}
