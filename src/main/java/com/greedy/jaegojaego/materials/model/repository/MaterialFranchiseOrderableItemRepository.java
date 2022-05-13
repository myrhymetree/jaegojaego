package com.greedy.jaegojaego.materials.model.repository;

import com.greedy.jaegojaego.materials.model.entity.FranchiseOrderableItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : MaterialFranchiseOrderableItemRepository
 * Comment : MaterialFranchiseOrderableItemRepository Entity관련 메소드를 모아놓은 MaterialFranchiseOrderableItemRepository입니다.
 * History
 * 2022/05/09 (김영광) MaterialFranchiseOrderableItemRepository 자재 판매가격 조회, 업데이트, 등록 설정
 * </pre>
 * @version
 * @author 김영광
 * */
public interface MaterialFranchiseOrderableItemRepository extends JpaRepository<FranchiseOrderableItem, Integer> {

}
