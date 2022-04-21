package com.greedy.jaegojaego.menu.entity;

import com.greedy.jaegojaego.menu.dto.MenuMaterialsDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "menuMaterialManufacture")
@Table(name = "MATERIAL_MANUFACTURE")
public class MenuMaterialManufacture implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private MenuMaterial itemInfoNo;

    @Column(name = "MATERIAL_MANUFACTURE_SUBDIVISION_UNIT")
    private int materialManufactureSubdivisionUnit;

    public MenuMaterialManufacture() {}

    public MenuMaterialManufacture(MenuMaterial itemInfoNo, int materialManufactureSubdivisionUnit) {
        this.itemInfoNo = itemInfoNo;
        this.materialManufactureSubdivisionUnit = materialManufactureSubdivisionUnit;
    }

    public MenuMaterial getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(MenuMaterial itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public int getMaterialManufactureSubdivisionUnit() {
        return materialManufactureSubdivisionUnit;
    }

    public void setMaterialManufactureSubdivisionUnit(int materialManufactureSubdivisionUnit) {
        this.materialManufactureSubdivisionUnit = materialManufactureSubdivisionUnit;
    }

    @Override
    public String toString() {
        return "MenuMaterialManufacture{" +
                "itemInfoNo=" + itemInfoNo +
                ", materialManufactureSubdivisionUnit=" + materialManufactureSubdivisionUnit +
                '}';
    }
}
