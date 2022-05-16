package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : OutWarehouseDetailRepository
 * Comment : 가맹점 발주 신청자 정보 조회 관련 로직 처리 메소드를 모아둔 Repository입니다.
 * History
 * 2022/04/21 (이태준) 가맹점 발주 신청자 정보 조회 로직
 * 2022/04/25 (이태준) 가맹점 발주 신청자 정보 조회 로직 수정
 * 2022/04/30 (이태준) 가맹점 발주 신청자 정보 조회 로직
 * 2022/05/03 (이태준) 가맹점 발주 신청자의 권한에 따른 조회 로직 작성
 * 2022/05/07 (이태준) 가맹점 발주 신청자 정보 조회 로직 마무리
 * </pre>
 * @version 1.3
 * @author 이태준
 * */
@Repository
public interface OutWarehouseMemberRepository extends JpaRepository<OutWarehouseMember, Integer> {

    /**
     * getMemberInfo : 가맹점 발주 신청자 정보 조회
     * @param memberNo : 가맹점 발주 신청자 회원번호
     * @return : 가맹점 발주 신청자 정보
     */
    @Query(value = "SELECT a " +
            "         FROM outWarehouseMember a " +
            "        WHERE a.memberNo = :memberNo")
    OutWarehouseMember getMemberInfo(int memberNo);

    /**
     * findByMemberNo : 가맹점 발주 신청자 정보 조회
     * @param memberNo : 가맹점 발주 신청자 회원번호
     * @return : 가맹점 발주 신청자 정보
     */
    OutWarehouseMember findByMemberNo(int memberNo);
}
