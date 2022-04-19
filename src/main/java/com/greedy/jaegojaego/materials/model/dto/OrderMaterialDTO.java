package com.greedy.jaegojaego.materials.model.dto;

<<<<<<< HEAD:src/main/java/com/greedy/jaegojaego/materials/model/dto/OrderMaterialDTO.java
public class OrderMaterialDTO {
=======
import com.greedy.jaegojaego.materials.model.entity.MaterialsCategory;

public class MaterialsDTO {

    private int itemInfoNo;                         //자재 번호
    private String itemInfoName;                    //자재 품명
    private String itemSerialNo;                    //자재 품번
    private MaterialsCategory materialsCategory;    //자재 카테고리
    private int orderAmount;                        //판매가격
    private int subdivisionUnit;                    //소분단위

    public MaterialsDTO() {
    }

    public MaterialsDTO(int itemInfoNo, String itemInfoName, String itemSerialNo, MaterialsCategory materialsCategory, int orderAmount, int subdivisionUnit) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemSerialNo = itemSerialNo;
        this.materialsCategory = materialsCategory;
        this.orderAmount = orderAmount;
        this.subdivisionUnit = subdivisionUnit;
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

    public String getItemSerialNo() {
        return itemSerialNo;
    }

    public void setItemSerialNo(String itemSerialNo) {
        this.itemSerialNo = itemSerialNo;
    }

    public MaterialsCategory getMaterialsCategory() {
        return materialsCategory;
    }

    public void setMaterialsCategory(MaterialsCategory materialsCategory) {
        this.materialsCategory = materialsCategory;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getSubdivisionUnit() {
        return subdivisionUnit;
    }

    public void setSubdivisionUnit(int subdivisionUnit) {
        this.subdivisionUnit = subdivisionUnit;
    }

    @Override
    public String toString() {
        return "MaterialsDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemSerialNo='" + itemSerialNo + '\'' +
                ", materialsCategory=" + materialsCategory +
                ", orderAmount=" + orderAmount +
                ", subdivisionUnit=" + subdivisionUnit +
                '}';
    }
>>>>>>> origin/feature/materials:src/main/java/com/greedy/jaegojaego/materials/model/dto/MaterialsDTO.java
}
