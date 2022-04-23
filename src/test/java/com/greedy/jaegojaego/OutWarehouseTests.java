package com.greedy.jaegojaego;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouse;
//import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseExpandsOutWarehouseStatusHistory;
//import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseExpandsOutWarehouseStatusHistory;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseItem;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OutWarehouseTests {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @Test
    public void test_작동_확인() {

    }

    @Test
    public void 출고_목록_조회_테스트() {

        //given

        //when
//        String query = "SELECT A.OUT_WAREHOUSE_NO, A.OUT_WAREHOUSE_WORKING_FINISHED_DATE, A.OUT_WAREHOUSE_WORKING_STATUS_NAME,  " +
//                "              B.FRANCHISE_BRANCH_NAME, B.FRANCHISE_ADDRESS, " +
//                "              A.OUT_WAREHOUSE_TOTAL_OUT_ITEM_AMOUNT\n" +
//                "         FROM OUT_WAREHOUSE A\n" +
//                "         JOIN FRANCHISE_INFO B ON (A.FRANCHISE_REPRESENTATIVE_NO = B.FRANCHISE_REPRESENTATIVE_NO)\n" +
//                "        ORDER BY A.OUT_WAREHOUSE_NO DESC";
        String query = "SELECT * FROM OUT_WAREHOUSE A JOIN FRANCHISE_INFO B ON (A.FRANCHISE_REPRESENTATIVE_NO = B.FRANCHISE_REPRESENTATIVE_NO) ORDER BY A.OUT_WAREHOUSE_NO DESC";
//        String query = "SELECT a.outWarehouseNo, a.outWarehouseWorkingFinishedDate, a.outWarehouseWorkingStatusName, a.outWarehouseTotalOutItemAmount, " +
//                "              b.franchiseBranchName, b.franchiseAddress\n" +
//                "         FROM OutWarehouse a\n" +
//                "         JOIN a.franchiseRepresentativeNo b";

        List<OutWarehouse> outWarehouseList =
                entityManager.createNativeQuery(query, OutWarehouse.class)
                        .getResultList();

        //then
        assertNotNull(outWarehouseList);
        outWarehouseList.forEach(System.out::println);
    }

    @Test
    public void 출고_목록_상세_조회_테스트() {

        int outWarehouseNo = 1;

        String query = "SELECT * " +
                "        FROM OUT_WAREHOUSE_ITEM A\n " +
                "        JOIN ITEM_WAREHOUSE B ON (A.ITEM_WAREHOUSE_NO = B.ITEM_WAREHOUSE_NO)\n " +
                "        JOIN ITEM_INFO C ON (B.ITEM_INFO_NO = C.ITEM_INFO_NO)\n " +
                "        JOIN MATERIAL_CATEGORY D ON (C.MATERIAL_CATEGORY_NO = D.MATERIAL_CATEGORY_NO)\n " +
                "        JOIN OUT_WAREHOUSE E ON (A.OUT_WAREHOUSE_NO = E.OUT_WAREHOUSE_NO)\n " +
                "        JOIN FRANCHISE_INFO F ON (E.FRANCHISE_REPRESENTATIVE_NO = F.FRANCHISE_REPRESENTATIVE_NO)\n " +
                "       WHERE A.OUT_WAREHOUSE_NO = ?";

        List<OutWarehouseItem> outWarehouseItemList = entityManager.createNativeQuery(query, OutWarehouseItem.class)
                .setParameter(1, outWarehouseNo)
                .getResultList();

        assertNotNull(outWarehouseItemList);
        outWarehouseItemList.forEach(System.out::println);
    }
}
