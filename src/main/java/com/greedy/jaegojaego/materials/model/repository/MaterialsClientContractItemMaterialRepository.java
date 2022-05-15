package com.greedy.jaegojaego.materials.model.repository;

import com.greedy.jaegojaego.materials.model.entity.ClientContractItemMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Class : MaterialsClientContractItemMaterialRepository
 * Comment : MaterialsClientContractItemMaterialRepository Entity관련 메소드를 모아놓은 MaterialsClientContractItemMaterialRepository입니다..
 * History
 * 2022/05/10 (김영광) MaterialsClientContractItemMaterialRepository 자재와 매치되지 않는 거래처상품, 거래처 조회
 * @version
 * @author 김영광
 * */
public interface MaterialsClientContractItemMaterialRepository extends JpaRepository<ClientContractItemMaterial, Integer> {

    @Query(value = "SELECT * " +
            "         FROM CLIENT_CONTRACT_ITEM A" +
            "        WHERE A.ITEM_INFO_NO IS NULL "
            , nativeQuery = true
    )
    List<ClientContractItemMaterial> findClientList();
}
