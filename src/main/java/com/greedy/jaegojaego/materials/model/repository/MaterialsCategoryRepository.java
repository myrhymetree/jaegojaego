package com.greedy.jaegojaego.materials.model.repository;

import com.greedy.jaegojaego.materials.model.entity.MaterialsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : MaterialsCategoryRepository
 * Comment : MaterialsCategoryRepository Entity관련 메소드를 모아놓은 MaterialsCategoryRepository입니다..
 * History
 * 2022/05/10 (김영광) MaterialsCategoryRepository 자재 카테고리 조회
 * </pre>
 * @version
 * @author 김영광
 * */
public interface MaterialsCategoryRepository extends JpaRepository<MaterialsCategory, Integer> {
    MaterialsCategory findByMaterialCategoryName(String materialCategoryName);
}
