package com.greedy.jaegojaego.order.item.model.dto;

import com.greedy.jaegojaego.order.material.model.dto.OrderMaterialCategoryDTO;
import lombok.*;

public class OrderItemInfoDTO {

    private int itemInfoNo;
    private String itemInfoName;
    private String itemInfoItemSerialNo;
    private OrderMaterialCategoryDTO materialCategory;
    private String itemInfoStatusYn;
    private String itemInfoDescription;

    public OrderItemInfoDTO() {
    }

    public OrderItemInfoDTO(int itemInfoNo, String itemInfoName, String itemInfoItemSerialNo, OrderMaterialCategoryDTO materialCategory, String itemInfoStatusYn, String itemInfoDescription) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
        this.materialCategory = materialCategory;
        this.itemInfoStatusYn = itemInfoStatusYn;
        this.itemInfoDescription = itemInfoDescription;
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

    public String getItemInfoItemSerialNo() {
        return itemInfoItemSerialNo;
    }

    public void setItemInfoItemSerialNo(String itemInfoItemSerialNo) {
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
    }

    public OrderMaterialCategoryDTO getMaterialCategory() {
        return materialCategory;
    }

    public void setMaterialCategory(OrderMaterialCategoryDTO materialCategory) {
        this.materialCategory = materialCategory;
    }

    public String getItemInfoStatusYn() {
        return itemInfoStatusYn;
    }

    public void setItemInfoStatusYn(String itemInfoStatusYn) {
        this.itemInfoStatusYn = itemInfoStatusYn;
    }

    public String getItemInfoDescription() {
        return itemInfoDescription;
    }

    public void setItemInfoDescription(String itemInfoDescription) {
        this.itemInfoDescription = itemInfoDescription;
    }

    @Override
    public String toString() {
        return "OrderItemInfoDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoItemSerialNo='" + itemInfoItemSerialNo + '\'' +
                ", materialCategory=" + materialCategory +
                ", itemInfoStatusYn='" + itemInfoStatusYn + '\'' +
                ", itemInfoDescription='" + itemInfoDescription + '\'' +
                '}';
    }
}
