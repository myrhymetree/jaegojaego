package com.greedy.jaegojaego.menu.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "rawMaterial")
@Table(name = "FINISHED_PRODUCT_CONFIGURATION_ITEM")
@IdClass(RawMaterialPK.class)
public class RawMaterial implements Serializable {

    //pk,fk -> 얘가 참조하는애의 pk를 fk로 받아오고 식별자 공유
    @Id
    @ManyToOne
    @JoinColumn(name = "FINISHED_PRODUCT_MENU_NO")
    private Menu menuNoforRaw;

    //pk, fk -> 다른 참조하는 애를 fk로 받아옴\
    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private MenuFranchiseOrderableItem itemInfoNo;
//    private List<MenuFranchiseOrderableItem> itemInfoNo;

    @Column(name = "FINISHED_PRODUCT_CONFIGURATION_ITEM_NAME")
    private String rawMaterialName;

    @Column(name = "FINISHED_PRODUCT_CONFIGURATION_ITEM_CAPACITY")
    private int rawMaterialCapacity;


    public RawMaterial() {}

    public RawMaterial(Menu menuNoforRaw, MenuFranchiseOrderableItem itemInfoNo, String rawMaterialName, int rawMaterialCapacity) {
        this.menuNoforRaw = menuNoforRaw;
        this.itemInfoNo = itemInfoNo;
        this.rawMaterialName = rawMaterialName;
        this.rawMaterialCapacity = rawMaterialCapacity;
    }

    public Menu getMenuNoforRaw() {
        return menuNoforRaw;
    }

    public void setMenuNoforRaw(Menu menuNoforRaw) {
        this.menuNoforRaw = menuNoforRaw;
    }

    public MenuFranchiseOrderableItem getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(MenuFranchiseOrderableItem itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public int getRawMaterialCapacity() {
        return rawMaterialCapacity;
    }

    public void setRawMaterialCapacity(int rawMaterialCapacity) {
        this.rawMaterialCapacity = rawMaterialCapacity;
    }

    @Override
    public String toString() {
        return "RawMaterial{" +
                "menuNoforRaw=" + menuNoforRaw +
                ", itemInfoNo=" + itemInfoNo +
                ", rawMaterialName='" + rawMaterialName + '\'' +
                ", rawMaterialCapacity=" + rawMaterialCapacity +
                '}';
    }
}
