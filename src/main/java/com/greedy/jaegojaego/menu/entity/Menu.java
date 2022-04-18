package com.greedy.jaegojaego.menu.entity;

import javax.persistence.*;

@Entity(name = "finshedProductMenu")
@Table(name = "FINISHED_PRODUCT_MENU")
@SequenceGenerator(
        name = "MENU_SEQ_GENERATOR",
        sequenceName = "SEQ_MENU_NO",
        initialValue = 1,
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

    public Menu() {}

    public Menu(int menuNo, String menuName, int menuPrice, String menuOrderableStatus) {
        this.menuNo = menuNo;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuOrderableStatus = menuOrderableStatus;
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

    @Override
    public String toString() {
        return "Menu{" +
                "menuNo=" + menuNo +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuOrderableStatus='" + menuOrderableStatus + '\'' +
                '}';
    }
}