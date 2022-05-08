package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import java.util.List;

import static com.greedy.jaegojaego.outWarehouse.model.entity.QOutWarehouseFranchiseOrder.outWarehouseFranchiseOrder;
import static com.greedy.jaegojaego.outWarehouse.model.entity.QOutWarehouseMember.outWarehouseMember;
import static com.greedy.jaegojaego.outWarehouse.model.entity.QOutwarehouseFranchiseAccount.outwarehouseFranchiseAccount;
import static com.greedy.jaegojaego.outWarehouse.model.entity.QOutWarehouseFranchiseInfo.outWarehouseFranchiseInfo;

public class OutWarehouseFranchiseOrderImpl extends QuerydslRepositorySupport implements OutWarehouseFranchiseOrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public OutWarehouseFranchiseOrderImpl(EntityManager em) {
        super(OutWarehouseFranchiseOrder.class);
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<OutWarehouseFranchiseOrder> getMemberNo() {

        return queryFactory
                .select(new QOutWarehouseFranchiseOrder(outWarehouseFranchiseOrder))
                .from(outWarehouseFranchiseOrder)
                .where(
                    outWarehouseFranchiseOrder.franchiseOrderStatus.eq("COMPLETE")
                )
                .fetch();
    }

    @Override
    public OutWarehouseMember getMemberInfo(int memberNo) {
        return queryFactory
                .select(new QOutWarehouseMember(outWarehouseMember))
                .from(outWarehouseMember)
                .where(
                        outWarehouseMember.memberNo.eq(memberNo)
                )
                .fetchOne();
    }

    @Override
    public OutWarehouseFranchiseInfo getFranchiseInfo(int memberNo, String division) {
        if (division == "대표자") {
            return queryFactory
                    .select(new QOutWarehouseFranchiseInfo(outWarehouseFranchiseInfo))
                    .from(outWarehouseFranchiseInfo)
                    .where(
                            outWarehouseMember.memberNo.eq(memberNo)
                    )
                    .fetchOne();
        } else {
            return queryFactory
                    .select(new QOutWarehouseFranchiseInfo(outWarehouseFranchiseInfo))
                    .from(outWarehouseFranchiseInfo)
                    .where(
                            outwarehouseFranchiseAccount.franchiseManagerNo.memberNo.eq(memberNo),
                            outWarehouseMember.memberNo.eq(outwarehouseFranchiseAccount.franchiseRepresentativeNo.franchiseRepresenetativeNo.memberNo)
                    )
                    .fetchOne();
        }
    }

}
