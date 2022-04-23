package com.greedy.jaegojaego.menu.repository;

import com.greedy.jaegojaego.menu.entity.Menu;
import com.greedy.jaegojaego.menu.entity.MenuMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : MenuMaterialRepository
 * Comment : MenuMaterial Entity관련 메소드를 모아놓은 Repository입니다.
 * History
 * 2022/04/21 (이소현) MenuMaterialRepository 기본 설정 작성
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see MenuMaterial , MenuService, MenuMaterialsDTO
 * */
@Repository
public interface MenuMaterialRepository extends JpaRepository<MenuMaterial, Integer> {



}
