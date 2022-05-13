package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * <pre>
 * Class : MemberRepository
 * Comment : 계정 Spring-data JPA 공통 레포지토리 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    /* 계정 정보 조회 메소드 */
    @EntityGraph(attributePaths = {"memberRoleList"}, type = EntityGraph.EntityGraphType.LOAD)
    Member findMemberByMemberId(String memberId);

    /* 계정 존재 여부 조회 메소드 */
    boolean existsByMemberId(String memberId);

    /* 계정 정보 조회 메소드(계정번호로 조회함) */
    Member findMemberByMemberNo(Integer memberNo);

}

