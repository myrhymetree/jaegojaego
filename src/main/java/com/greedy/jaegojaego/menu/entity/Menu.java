package com.greedy.jaegojaego.menu.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "finshedProductMenu")
@Table(name = "FINISHED_PRODUCT_MENU")
@SequenceGenerator(
        name = "MENU_SEQ_GENERATOR",
        sequenceName = "MENU_NO",
        initialValue = 1, //1로 하면 무결성 떠서 일단 11로
        allocationSize = 1
)
public class Menu {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MENU_SEQ_GENERATOR"
    )
    @Column(name = "FINISHED_PRODUCT_MENU_NO")
    private int menuNo;

    @Column(name = "FINISHED_PRODUCT_MENU_NAME")
    private String menuName;

    @Column(name = "FINISHED_PRODUCT_MENU_PRICE")
    private int menuPrice;

    @Column(name = "FINISHED_PRODUCT_MENU_ORDERABLE")
    private String menuOrderableStatus;

    @JoinColumn(name = "FINISHED_PRODUCT_MENU_NO", updatable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<RawMaterial> rawMaterialList;


    public Menu() {}

    public Menu(int menuNo, String menuName, int menuPrice, String menuOrderableStatus, List<RawMaterial> rawMaterialList) {
        this.menuNo = menuNo;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuOrderableStatus = menuOrderableStatus;
        this.rawMaterialList = rawMaterialList;
    }

    public int getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(int menuNo) {
        this.menuNo = menuNo;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuOrderableStatus() {
        return menuOrderableStatus;
    }

    public void setMenuOrderableStatus(String menuOrderableStatus) {
        this.menuOrderableStatus = menuOrderableStatus;
    }

    public List<RawMaterial> getRawMaterialList() {
        return rawMaterialList;
    }

    public void setRawMaterialList(List<RawMaterial> rawMaterialList) {
        this.rawMaterialList = rawMaterialList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuNo=" + menuNo +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuOrderableStatus='" + menuOrderableStatus + '\'' +
//                ", rawMaterialList=" + rawMaterialList +
                '}';
    }
}