package com.greedy.jaegojaego.order.material.model.dto;

import lombok.*;

public class OrderMaterialCategoryDTO {

    private int materialCategoryNo;
    private String materialCategoryName;

    public OrderMaterialCategoryDTO() {
    }

    public OrderMaterialCategoryDTO(int materialCategoryNo, String materialCategoryName) {
        this.materialCategoryNo = materialCategoryNo;
        this.materialCategoryName = materialCategoryName;
    }

    public int getMaterialCategoryNo() {
        return materialCategoryNo;
    }

    public void setMaterialCategoryNo(int materialCategoryNo) {
        this.materialCategoryNo = materialCategoryNo;
    }

    public String getMaterialCategoryName() {
        return materialCategoryName;
    }

    public void setMaterialCategoryName(String materialCategoryName) {
        this.materialCategoryName = materialCategoryName;
    }

    @Override
    public String toString() {
        return "OrderMaterialCategoryDTO{" +
                "materialCategoryNo=" + materialCategoryNo +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
