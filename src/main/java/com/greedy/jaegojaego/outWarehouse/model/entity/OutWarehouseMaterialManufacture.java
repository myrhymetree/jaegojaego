package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "OutWarehouseMaterialManufacture")
@Table(name = "MATERIAL_MANUFACTURE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutWarehouseMaterialManufacture implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OutWarehouseMaterials itemInfoNo;

    @Column(name = "MATERIAL_MANUFACTURE_SUBDIVISION_UNIT")
    private int materialManufactureSubdivisionUnit;

    @Override
    public String toString() {
        return "OutWarehouseMaterialManufacture{" +
                "itemInfoNo=" + itemInfoNo +
                ", materialManufactureSubdivisionUnit=" + materialManufactureSubdivisionUnit +
                '}';
    }
}
