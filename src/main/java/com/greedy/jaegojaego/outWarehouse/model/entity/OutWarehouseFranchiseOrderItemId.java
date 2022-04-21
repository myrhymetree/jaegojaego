package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OutWarehouseFranchiseOrderItemId implements Serializable {

    private OutWarehouseFranchiseOrder franchiseOrderNo;
    private OutWarehouseFranchiseOrderableItem itemInfoNo;
}
