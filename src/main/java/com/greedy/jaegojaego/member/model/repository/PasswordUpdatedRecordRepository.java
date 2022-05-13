package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.entity.PasswordUpdatedRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * Class : PasswordUpdatedRecordRepository
 * Comment : 계정 정보 수정 이력 Spring-data JPA 공통 레포지토리 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Repository
@Transactional
public interface PasswordUpdatedRecordRepository extends JpaRepository<PasswordUpdatedRecord, Integer> {

}
