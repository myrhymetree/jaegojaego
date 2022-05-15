package com.greedy.jaegojaego.materials.model.repository;

import com.greedy.jaegojaego.materials.model.entity.ClientContractItem;
import com.greedy.jaegojaego.materials.model.entity.ClientPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Class : MaterialsClientContractItemRepository
 * Comment : MaterialsClientContractItemRepository Entity관련 메소드를 모아놓은 MaterialsClientContractItemRepository입니다.
 * History
 * 2022/05/10 (김영광) MaterialsClientContractItemRepository 자재와 매치된 거래처, 계약된 거래처 상품 조회
 * @version
 * @author 김영광
 * */
public interface MaterialsClientContractItemRepository extends JpaRepository<ClientContractItem, ClientPK> {

    @Query(value = "SELECT * " +
            "         FROM CLIENT_CONTRACT_ITEM A" +
            "        WHERE A.ITEM_INFO_NO = :itemInfoNo"
            , nativeQuery = true
    )
    List<ClientContractItem> findAllClientList(int itemInfoNo);

}
