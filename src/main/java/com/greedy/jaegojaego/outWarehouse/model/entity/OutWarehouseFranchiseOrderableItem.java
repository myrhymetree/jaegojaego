package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FRANCHISE_ORDERABLE_ITEM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutWarehouseFranchiseOrderableItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OutWarehouseMaterials itemInfoNo;

    @Override
    public String toString() {
        return "OutWarehouseFranchiseOrderableItem{" +
                "itemInfoNo=" + itemInfoNo +
                '}';
    }
}
