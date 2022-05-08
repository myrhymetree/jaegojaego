package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseInfo;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrder;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseMember;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutwarehouseFranchiseAccount;

import java.util.List;

public interface OutWarehouseFranchiseOrderRepositoryCustom {

    List<OutWarehouseFranchiseOrder> getMemberNo();

    OutWarehouseMember getMemberInfo(int memberNo);

    OutWarehouseFranchiseInfo getFranchiseInfo(int memberNo, String division);
}
