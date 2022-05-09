package com.greedy.jaegojaego.warehouse.entity;

import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.warehouse.dto.WarehouseItemInfoDTO;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@DynamicUpdate
@Entity(name = "warehouseItemAmount")
@Table(name = "ITEM_AMOUNT")
public class WarehouseItemAmount {

    @Id
    @Column(name = "ITEM_INFO_NO")
    private Integer warehouseItemInfoNo;

    @OneToOne(mappedBy = "warehouseItemAmount")
    private WarehouseItemInfo warehouseItemInfo;

    @Column(name = "ITEM_INFO_TOTAL_AMOUNT")
    private int warehouseItemAmount;

    @Override
    public String toString() {
        return "WarehouseItemAmount{" +
                "warehouseItemInfoNo=" + warehouseItemInfoNo +
                ", warehouseItemInfo=" + warehouseItemInfo +
                ", warehouseItemAmount=" + warehouseItemAmount +
                '}';
    }
}
