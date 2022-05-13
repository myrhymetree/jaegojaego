package com.greedy.jaegojaego.materials.model.repository;

import com.greedy.jaegojaego.materials.model.entity.MaterialFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : MaterialFileRepository
 * Comment : MaterialFileRepository Entity관련 메소드를 모아놓은 Repository입니다.
 * History
 * 2022/05/12 (김영광) MaterialFileRepository 파일 등록 설정
 * </pre>
 * @version
 * @author 김영광
 * */
public interface MaterialFileRepository extends JpaRepository<MaterialFile, Integer> {
}
