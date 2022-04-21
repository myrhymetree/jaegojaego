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
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MENUMATERIAL_SEQ_GENERATOR"
    )
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @Column(name = "ITEM_INFO_SERIAL_NO")
    private String itemInfoSerialNo;

    @Column(name = "ITEM_INFO_STATUS_YN")
    private String itemInfoStatus;

    @ManyToOne
    @JoinColumn(name = "MATERIAL_CATEGORY_NO")
    private MenuMaterialsCategory menuMaterialsCategoryNo;

    public MenuMaterial() {}

    public MenuMaterial(int itemInfoNo, String itemInfoName, String itemInfoSerialNo, String itemInfoStatus, MenuMaterialsCategory menuMaterialsCategoryNo) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemInfoSerialNo = itemInfoSerialNo;
        this.itemInfoStatus = itemInfoStatus;
        this.menuMaterialsCategoryNo = menuMaterialsCategoryNo;
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

    @Override
    public String toString() {
        return "MenuMaterial{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoSerialNo='" + itemInfoSerialNo + '\'' +
                ", itemInfoStatus='" + itemInfoStatus + '\'' +
                ", menuMaterialsCategoryNo=" + menuMaterialsCategoryNo +
                '}';
    }
}
