package com.greedy.jaegojaego.menu.repository;

import com.greedy.jaegojaego.menu.entity.Menu;
import com.greedy.jaegojaego.menu.entity.MenuMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : MenuMaterialRepository
 * Comment : MenuMaterial Entity관련 메소드를 모아놓은 Repository입니다.
 * History
 * 2022/04/21 (이소현) MenuMaterialRepository 기본 설정 작성
 * 2022/04/25 (이소현) 메뉴 등록
 * </pre>
 * @version 2
 * @author 이소현
 * */
@Repository
public interface MenuMaterialRepository extends JpaRepository<MenuMaterial, Integer> {

    @Query(
            value = "SELECT * " +
                    "  FROM ITEM_INFO A " +
                    " WHERE A.ITEM_INFO_NAME = :menuName", nativeQuery = true
    )
    MenuMaterial selectMenuMaterialBymenuName(String menuName);
}

