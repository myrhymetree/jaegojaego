package com.greedy.jaegojaego.materials.model.repository;

import com.greedy.jaegojaego.materials.model.entity.ClientContractItem;
import com.greedy.jaegojaego.materials.model.entity.ClientPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaterialsClientContractItemRepository extends JpaRepository<ClientContractItem, ClientPK> {

    @Query(value = "SELECT * " +
            "         FROM CLIENT_CONTRACT_ITEM A" +
            "        WHERE A.ITEM_INFO_NO = :itemInfoNo"
            , nativeQuery = true
    )
    List<ClientContractItem> findAllClientList(int itemInfoNo);

    /*@Query(value = "SELECT * " +
            "         FROM CLIENT_CONTRACT_ITEM A" +
            "        WHERE A.ITEM_INFO_NO IS NULL "
            , nativeQuery = true
    )
    List<ClientContractItem> findClientList();*/
}
