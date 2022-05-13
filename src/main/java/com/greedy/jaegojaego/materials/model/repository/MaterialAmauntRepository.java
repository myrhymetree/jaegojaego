package com.greedy.jaegojaego.materials.model.repository;


import com.greedy.jaegojaego.materials.model.entity.Material;
import com.greedy.jaegojaego.materials.model.entity.MaterialItemAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <pre>
 * Class : MaterialRepository
 * Comment : MaterialRepository Entity관련 메소드를 모아놓은 MaterialRepository입니다.
 * History
 * 2022/05/11 (김영광) MaterialRepository 자재 전체 행 조회, 자재 연관매핑 조회
 * </pre>
 * @version
 * @author 김영광
 * */
public interface MaterialAmauntRepository extends JpaRepository<MaterialItemAmount, Integer> {

}

