package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.MemberSearchCondition;
import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface CompanyAccountRepositoryCustom {

    List<CompanyAccount> searchMembers(String searchWord);

    void updateMember(CompanyAccount member);
}
