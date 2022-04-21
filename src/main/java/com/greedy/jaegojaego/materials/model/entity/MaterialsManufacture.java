package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "MaterialsManufacture")
@Table(name = "MATERIAL_MANUFACTURE")
public class MaterialsManufacture {

    @Id
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Column(name = "MATERIAL_MANUFACTURE_SUBDIVISION_UNIT")
    private int subdivisionUnit;

    public MaterialsManufacture() {
    }

    public MaterialsManufacture(int itemInfoNo, int subdivisionUnit) {
        this.itemInfoNo = itemInfoNo;
        this.subdivisionUnit = subdivisionUnit;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public int getSubdivisionUnit() {
        return subdivisionUnit;
    }

    public void setSubdivisionUnit(int subdivisionUnit) {
        this.subdivisionUnit = subdivisionUnit;
    }

    @Override
    public String toString() {
        return "MaterialsManufacture{" +
                "itemInfoNo=" + itemInfoNo +
                ", subdivisionUnit=" + subdivisionUnit +
                '}';
    }
}
