package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.entity.Department;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.member.model.entity.MemberRole;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    /* By 다음에 기술할 필드명을 써야한다 */
    @EntityGraph(attributePaths = {"memberRoleList"}, type = EntityGraph.EntityGraphType.LOAD)
    Member findMemberByMemberId(String memberId);

//    @Query(value = "SELECT a.memberNo FROM companyAccount a WHERE a.memberId = ?1")
//    List<MemberRole> findByMemberNo(int memberNo);

    boolean existsByMemberId(String memberId);

    Member findMemberPwdByMemberNo(Integer memberNo);

}

