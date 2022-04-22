package com.greedy.jaegojaego.menu.repository;


import com.greedy.jaegojaego.menu.entity.Menu;
import com.greedy.jaegojaego.menu.entity.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : MenuRepository
 * Comment : Menu Entity관련 메소드를 모아놓은 Repository입니다.
 * History
 * 2022/04/18 (이소현) MenuRepository 기본 설정 작성
 * 2022/04/19 (이소현) 메뉴 페이지 이동
 * 2022/04/20 (이소현) 매뉴 목록 조회
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see Menu, MenuService, MenuDTO
 * */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
