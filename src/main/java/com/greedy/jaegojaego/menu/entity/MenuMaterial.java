package com.greedy.jaegojaego.menu.entity;

import com.greedy.jaegojaego.menu.dto.MenuMaterialsCategoryDTO;
import com.greedy.jaegojaego.menu.dto.MenuMaterialsDTO;

import javax.persistence.*;

@Entity(name = "menuMaterial")
@Table(name = "ITEM_INFO")
@SequenceGenerator(
        name = "MENUMATERIAL_SEQ_GENERATOR",
        sequenceName = "SEQ_MENUMATERIAL_NO",
        initialValue = 1,
        allocationSize = 1
)
public class MenuMaterial {

    @Id
    @GeneratedValue( //이거때문인가 싶어서 없애고 해봣는데도 똑같음 음..
            strategy = GenerationType.SEQUENCE,
            generator = "MENUMATERIAL_SEQ_GENERATOR"
    )
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @Column(name = "ITEM_INFO_ITEM_SERIAL_NO")
    private String itemInfoSerialNo;

    @Column(name = "ITEM_INFO_STATUS_YN")
    private String itemInfoStatus;

    @ManyToOne
    @JoinColumn(name = "MATERIAL_CATEGORY_NO")
    private MenuMaterialsCategory menuMaterialsCategoryNo;

    @Column(name = "SUBDIVISION_UNIT")
    private Integer subdivisionUnit;

    @Column(name = "SUBDIVISION_YN")
    private String subdivisionYN;

    public MenuMaterial() {}

    public MenuMaterial(int itemInfoNo, String itemInfoName, String itemInfoSerialNo, String itemInfoStatus, MenuMaterialsCategory menuMaterialsCategoryNo, Integer subdivisionUnit, String subdivisionYN) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemInfoSerialNo = itemInfoSerialNo;
        this.itemInfoStatus = itemInfoStatus;
        this.menuMaterialsCategoryNo = menuMaterialsCategoryNo;
        this.subdivisionUnit = subdivisionUnit;
        this.subdivisionYN = subdivisionYN;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public String getItemInfoName() {
        return itemInfoName;
    }

    public void setItemInfoName(String itemInfoName) {
        this.itemInfoName = itemInfoName;
    }

    public String getItemInfoSerialNo() {
        return itemInfoSerialNo;
    }

    public void setItemInfoSerialNo(String itemInfoSerialNo) {
        this.itemInfoSerialNo = itemInfoSerialNo;
    }

    public String getItemInfoStatus() {
        return itemInfoStatus;
    }

    public void setItemInfoStatus(String itemInfoStatus) {
        this.itemInfoStatus = itemInfoStatus;
    }

    public MenuMaterialsCategory getMenuMaterialsCategoryNo() {
        return menuMaterialsCategoryNo;
    }

    public void setMenuMaterialsCategoryNo(MenuMaterialsCategory menuMaterialsCategoryNo) {
        this.menuMaterialsCategoryNo = menuMaterialsCategoryNo;
    }

    public Integer getSubdivisionUnit() {
        return subdivisionUnit;
    }

    public void setSubdivisionUnit(Integer subdivisionUnit) {
        this.subdivisionUnit = subdivisionUnit;
    }

    public String getSubdivisionYN() {
        return subdivisionYN;
    }

    public void setSubdivisionYN(String subdivisionYN) {
        this.subdivisionYN = subdivisionYN;
    }

    @Override
    public String toString() {
        return "MenuMaterial{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoSerialNo='" + itemInfoSerialNo + '\'' +
                ", itemInfoStatus='" + itemInfoStatus + '\'' +
                ", menuMaterialsCategoryNo=" + menuMaterialsCategoryNo +
                ", subdivisionUnit=" + subdivisionUnit +
                ", subdivisionYN='" + subdivisionYN + '\'' +
                '}';
    }
}
