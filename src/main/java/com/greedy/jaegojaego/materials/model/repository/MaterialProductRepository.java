package com.greedy.jaegojaego.materials.model.repository;


import com.greedy.jaegojaego.materials.model.entity.Material;
import com.greedy.jaegojaego.materials.model.entity.MaterialProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <pre>
 * Class : MaterialProductRepository
 * Comment : MaterialProductRepository Entity관련 메소드를 모아놓은 MaterialProductRepository입니다.
 * History
 * 2022/05/11 (김영광) MaterialProductRepository 자재 상품 등록, 업데이트
 * </pre>
 * @version
 * @author 김영광
 * */
public interface MaterialProductRepository extends JpaRepository<MaterialProduct, Integer> {

}

