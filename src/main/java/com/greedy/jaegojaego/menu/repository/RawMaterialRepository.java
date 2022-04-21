package com.greedy.jaegojaego.menu.repository;

import com.greedy.jaegojaego.menu.entity.Menu;
import com.greedy.jaegojaego.menu.entity.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Integer> {

    @Query(
            value = "SELECT A.FINISHED_PRODUCT_CONFIGURATION_ITEM_NAME " +
                    "  FROM FINISHED_PRODUCT_CONFIGURATION_ITEM A " +
                    "  JOIN FRANCHISE_ORDERABLE_ITEM B ON (B.ITEM_INFO_NO = A.ITEM_INFO_NO) " +
                    "  JOIN MATERIAL_MANUFACTURE C ON (C.ITEM_INFO_NO = B.ITEM_INFO_NO) " +
                    "  JOIN ITEM_INFO D ON (D.ITEM_INFO_NO = C.ITEM_INFO_NO) " +
                    "  JOIN FINISHED_PRODUCT_MENU F ON (A.FINISHED_PRODUCT_MENU_NO = F.FINISHED_PRODUCT_MENU_NO) " +
                    " WHERE F.FINISHED_PRODUCT_MENU_NO = :menuNo", nativeQuery = true
    )
    List<String> selectStringList(int menuNo);

    @Query(
            value = "SELECT A.FINISHED_PRODUCT_CONFIGURATION_ITEM_CAPACITY " +
                    "  FROM FINISHED_PRODUCT_CONFIGURATION_ITEM A " +
                    "  JOIN FRANCHISE_ORDERABLE_ITEM B ON (B.ITEM_INFO_NO = A.ITEM_INFO_NO) " +
                    "  JOIN MATERIAL_MANUFACTURE C ON (C.ITEM_INFO_NO = B.ITEM_INFO_NO) " +
                    "  JOIN ITEM_INFO D ON (D.ITEM_INFO_NO = C.ITEM_INFO_NO) " +
                    "  JOIN FINISHED_PRODUCT_MENU F ON (A.FINISHED_PRODUCT_MENU_NO = F.FINISHED_PRODUCT_MENU_NO) " +
                    " WHERE F.FINISHED_PRODUCT_MENU_NO = :menuNo", nativeQuery = true
    )
    List<Integer> selectintList(int menuNo);

}
