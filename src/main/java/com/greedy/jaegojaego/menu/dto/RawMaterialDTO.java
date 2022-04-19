package com.greedy.jaegojaego.menu.dto;


import java.util.List;

public class RawMaterialDTO {

    private String rawMaterialName;
    private int rawMaterialCapacity;
    private MenuDTO menuNo;
    private List<RawMaterialDTO> materialNo;

    public RawMaterialDTO() {}

    public RawMaterialDTO(String rawMaterialName, int rawMaterialCapacity, MenuDTO menuNo, List<RawMaterialDTO> materialNo) {
        this.rawMaterialName = rawMaterialName;
        this.rawMaterialCapacity = rawMaterialCapacity;
        this.menuNo = menuNo;
        this.materialNo = materialNo;
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

    public MenuDTO getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(MenuDTO menuNo) {
        this.menuNo = menuNo;
    }

    public List<RawMaterialDTO> getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(List<RawMaterialDTO> materialNo) {
        this.materialNo = materialNo;
    }

    @Override
    public String toString() {
        return "RawMaterialDTO{" +
                "rawMaterialName='" + rawMaterialName + '\'' +
                ", rawMaterialCapacity=" + rawMaterialCapacity +
                ", menuNo=" + menuNo +
                ", materialNo=" + materialNo +
                '}';
    }
}
