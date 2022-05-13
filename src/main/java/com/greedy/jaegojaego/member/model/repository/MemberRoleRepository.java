package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.entity.MemberRole;
import com.greedy.jaegojaego.member.model.entity.MemberRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : MemberRoleRepository
 * Comment : 계정 권한 Spring-data JPA 공통 레포지토리 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Repository
public interface MemberRoleRepository extends JpaRepository<MemberRole, MemberRolePK> {

    /* 권한 목록 조회 메소드 */
    List<MemberRole> findAll();
}
