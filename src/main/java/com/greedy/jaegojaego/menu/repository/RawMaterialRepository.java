package com.greedy.jaegojaego.menu.repository;

import com.greedy.jaegojaego.menu.entity.RawMaterial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : RawMaterialRepository
 * Comment : RawMaterial Entity관련 메소드를 모아놓은 Repository입니다.
 * History
 * 2022/04/19 (이소현) RawMaterialRepository 기본 설정 작성
 * 2022/04/20 (이소현) 메뉴 상세 조회
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see RawMaterial, MenuService, RawMaterialDTO
 * */
@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Integer> {

        @Query(
            value = "SELECT *  " +
                    "  FROM FINISHED_PRODUCT_CONFIGURATION_ITEM A " +
                    "  JOIN ITEM_INFO B ON (B.ITEM_INFO_NO = A.ITEM_INFO_NO) " +
                    "  JOIN FINISHED_PRODUCT_MENU C ON (A.FINISHED_PRODUCT_MENU_NO = C.FINISHED_PRODUCT_MENU_NO) " +
                    " WHERE C.FINISHED_PRODUCT_MENU_NO = :menuNo", nativeQuery = true
    )
    List<RawMaterial> selectOneMenu(int menuNo);
}
