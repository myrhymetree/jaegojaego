package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.entity.MemberRole;
import com.greedy.jaegojaego.member.model.entity.MemberRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRoleRepository extends JpaRepository<MemberRole, MemberRolePK> {

    List<MemberRole> findAll();
}
