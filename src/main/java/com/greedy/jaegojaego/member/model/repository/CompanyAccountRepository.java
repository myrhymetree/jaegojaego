package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import com.greedy.jaegojaego.member.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyAccountRepository extends JpaRepository<CompanyAccount, Integer> {

    List<CompanyAccount> findAll();
}