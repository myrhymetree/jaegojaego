package com.greedy.jaegojaego.materials.model.repository;

import com.greedy.jaegojaego.materials.model.entity.ClientContractItemMaterial;
import com.greedy.jaegojaego.materials.model.entity.ClientMaterialUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Class : MaterialsClientUpdateRepository
 * Comment : MaterialsClientUpdateRepository Entity관련 메소드를 모아놓은 MaterialsClientUpdateRepository입니다.
 * History
 * 2022/05/10 (김영광) MaterialsClientUpdateRepository 자재와 거래처 매핑되어 거래처와 거래처 상품을 업데이트하기 위한 조회
 * @version
 * @author 김영광
 * */
public interface MaterialsClientUpdateRepository extends JpaRepository<ClientMaterialUpdate, Integer> {

    @Query(value = "SELECT a " +
            "         FROM materialsClientUpdateMaterial a " +
            "        WHERE a.clientItemNo = :clientItemNo"
    )
    ClientMaterialUpdate findUpdate(int clientItemNo);
}
