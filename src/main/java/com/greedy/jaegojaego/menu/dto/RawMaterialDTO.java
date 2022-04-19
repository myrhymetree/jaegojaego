package com.greedy.jaegojaego.menu.dto;

import com.greedy.jaegojaego.materials.model.dto.MaterialsDTO;

import java.util.List;

public class RawMaterialDTO {

    private String rawMaterialName;
    private int rawMaterialCapacity;
    private MenuDTO menuNo;
    private List<MaterialsDTO> materialNo;

    public RawMaterialDTO() {}

    public RawMaterialDTO(String rawMaterialName, int rawMaterialCapacity, MenuDTO menuNo, List<MaterialsDTO> materialNo) {
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

    public List<MaterialsDTO> getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(List<MaterialsDTO> materialNo) {
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
