package com.greedy.jaegojaego.materials.model.repository;


import com.greedy.jaegojaego.materials.model.entity.Materials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Class : MaterialsRepository
 * Comment : MaterialsRepository Entity관련 메소드를 모아놓은 MaterialsRepository입니다.
 * History
 * 2022/04/20 (김영광) findAllProductList 자재 전체 목록 조회
 * 2022/04/25 (김영광) findByMaterialsByCode 자재 상세 조회
 * @version
 * @author 김영광
 * */
public interface MaterialsRepository extends JpaRepository<Materials, Integer> {

    @Query(value = "SELECT * " +
            "         FROM ITEM_INFO A" +
            "         JOIN FRANCHISE_ORDERABLE_ITEM B ON(A.ITEM_INFO_NO = B.ITEM_INFO_NO)" +
            "         JOIN MATERIAL_CATEGORY C ON(A.MATERIAL_CATEGORY_NO = C.MATERIAL_CATEGORY_NO)" +
            "        WHERE ITEM_INFO_STATUS_YN = 'N'" +
            "        ORDER BY A.ITEM_INFO_NO ASC"
            , nativeQuery = true)
    List<Materials> findAllProductList();

    @Query(value = "SELECT * " +
            "         FROM ITEM_INFO A" +
            "         JOIN FRANCHISE_ORDERABLE_ITEM B ON(A.ITEM_INFO_NO = B.ITEM_INFO_NO)" +
            "         JOIN MATERIAL_CATEGORY C ON(A.MATERIAL_CATEGORY_NO = C.MATERIAL_CATEGORY_NO)" +
            "        WHERE A.ITEM_INFO_NO = :itemInfoNo"
            , nativeQuery = true
    )
    Materials findByMaterialsByCode(int itemInfoNo);
}

