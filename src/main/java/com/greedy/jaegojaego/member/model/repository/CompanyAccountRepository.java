package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyAccountRepository extends JpaRepository<CompanyAccount, Integer>, CompanyAccountRepositoryCustom {

    List<CompanyAccount> findAll();

    Integer countAllBy();

    CompanyAccount findAllByMemberNoAndMemberDivision(Integer memberNo, String memberDivision);

    CompanyAccount findByMemberNo(Integer memberNo);
}
