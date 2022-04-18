package com.greedy.jaegojaego.menu.dto;

public class MenuDTO {

    private int menuNo;
    private String menuName;
    private int menuPrice;
    private String menuOrderableStatus;

    public MenuDTO() {}

    public MenuDTO(int menuNo, String menuName, int menuPrice, String menuOrderableStatus) {
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
        return "MenuDTO{" +
                "menuNo=" + menuNo +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuOrderableStatus='" + menuOrderableStatus + '\'' +
                '}';
    }
}
