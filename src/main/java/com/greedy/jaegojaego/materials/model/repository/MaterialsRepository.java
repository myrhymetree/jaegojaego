package com.greedy.jaegojaego.materials.model.repository;


import com.greedy.jaegojaego.materials.model.entity.Materials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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

