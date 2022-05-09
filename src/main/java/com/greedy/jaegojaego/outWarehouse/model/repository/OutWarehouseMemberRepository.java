package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OutWarehouseMemberRepository extends JpaRepository<OutWarehouseMember, Integer> {

    @Query(value = "SELECT a " +
            "         FROM outWarehouseMember a " +
            "        WHERE a.memberNo = :memberNo")
    OutWarehouseMember getMemberInfo(int memberNo);
}
