package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutWarehouseDetailRespository extends JpaRepository<OutWarehouseFranchiseOrderItem, Integer> {
//
//    @Query(value = "SELECT a, b, c, d, e " +
//            "         FROM OutWarehouseItem a " +
//            "         JOIN a.outWarehouseNo b " +
//            "         JOIN a.itemWarehouseNo c " +
//            "         JOIN b.franchiseRepresentativeNo d " +
//            "         JOIN c.itemInfoNo e " +
//            "         JOIN e.materialCategoryNo f " +
//            "        WHERE a.outWarehouseNo.outWarehouseNo = :outWarehouseNo")
//    List<OutWarehouseItem> findByOutWarehouseNo(int outWarehouseNo);

    @Query(value = "SELECT A.FRANCHISE_ORDER_NO, A.FRANCHISE_ORDER_ITEM_AMOUNT, " +
            "              B.ITEM_INFO_NO, B.ITEM_INFO_ITEM_SERIAL_NO, B.ITEM_INFO_NAME, " +
            "              C.MATERIAL_CATEGORY_NO, C.MATERIAL_CATEGORY_NAME " +
            "         FROM FRANCHISE_ORDER_ITEM A " +
            "         JOIN ITEM_INFO B ON (A.ITEM_INFO_NO = B.ITEM_INFO_NO) " +
            "         JOIN MATERIAL_CATEGORY C ON (B.MATERIAL_CATEGORY_NO = C.MATERIAL_CATEGORY_NO) " +
            "         JOIN OUT_WAREHOUSE D ON (D.FRANCHISE_ORDER_NO = A.FRANCHISE_ORDER_NO) " +
            "        WHERE D.OUT_WAREHOUSE_NO = :outWarehouseNo", nativeQuery = true)
    List<OutWarehouseFranchiseOrderItem> findAllFranchiseOrderItemList(int outWarehouseNo);
}
