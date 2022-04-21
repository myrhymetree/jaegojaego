package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "OutWarehouseMaterialManufacture")
@Table(name = "MATERIAL_MANUFACTURE")
public class OutWarehouseMaterialManufacture implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OutWarehouseMaterials itemInfoNo;

    @Column(name = "MATERIAL_MANUFACTURE_SUBDIVISION_UNIT")
    private int materialManufactureSubdivisionUnit;

    public OutWarehouseMaterialManufacture() {}

    public OutWarehouseMaterialManufacture(OutWarehouseMaterials itemInfoNo, int materialManufactureSubdivisionUnit) {
        this.itemInfoNo = itemInfoNo;
        this.materialManufactureSubdivisionUnit = materialManufactureSubdivisionUnit;
    }

    public OutWarehouseMaterials getItemInfoNo() {
        return itemInfoNo;
    }

    public int getMaterialManufactureSubdivisionUnit() {
        return materialManufactureSubdivisionUnit;
    }

    public void setItemInfoNo(OutWarehouseMaterials itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public void setMaterialManufactureSubdivisionUnit(int materialManufactureSubdivisionUnit) {
        this.materialManufactureSubdivisionUnit = materialManufactureSubdivisionUnit;
    }

    @Override
    public String toString() {
        return "OutWarehouseMaterialManufacture{" +
                "itemInfoNo=" + itemInfoNo +
                ", materialManufactureSubdivisionUnit=" + materialManufactureSubdivisionUnit +
                '}';
    }
}
