package com.greedy.jaegojaego.materials.model.repository;

import com.greedy.jaegojaego.materials.model.entity.ClientContractItemMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaterialsClientContractItemMaterialRepository extends JpaRepository<ClientContractItemMaterial, Integer> {

    @Query(value = "SELECT * " +
            "         FROM CLIENT_CONTRACT_ITEM A" +
            "        WHERE A.ITEM_INFO_NO IS NULL "
            , nativeQuery = true
    )
    List<ClientContractItemMaterial> findClientList();
}
