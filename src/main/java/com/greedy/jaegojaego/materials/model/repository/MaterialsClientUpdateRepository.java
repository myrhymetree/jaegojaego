package com.greedy.jaegojaego.materials.model.repository;

import com.greedy.jaegojaego.materials.model.entity.ClientContractItemMaterial;
import com.greedy.jaegojaego.materials.model.entity.ClientMaterialUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaterialsClientUpdateRepository extends JpaRepository<ClientMaterialUpdate, Integer> {

    @Query(value = "SELECT a " +
            "         FROM materialsClientUpdateMaterial a " +
            "        WHERE a.clientItemNo = :clientItemNo"
    )
    ClientMaterialUpdate findUpdate(int clientItemNo);
}
