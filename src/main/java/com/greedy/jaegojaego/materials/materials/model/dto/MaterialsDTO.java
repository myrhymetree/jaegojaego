package com.greedy.jaegojaego.materials.model.dto;

public class MaterialsDTO {

    private int itemInfoNo;                            //자재 번호
    private String itemInfoName;                       //자재 품명
    private String itemSerialNo;                       //자재 품번
    private MaterialsCategoryDTO materialsCategory;    //자재 카테고리
    private String itemStatus;                         //자재 삭제 상태
    private Integer subdivisionUnit;                   //자재 소분
    private String subdivisionYN;                      //자재 가공 유무
    private int itemPrice;                             //자재 가격

    public MaterialsDTO() {
    }

    public MaterialsDTO(int itemInfoNo, String itemInfoName, String itemSerialNo, MaterialsCategoryDTO materialsCategory, String itemStatus, Integer subdivisionUnit, String subdivisionYN, int itemPrice) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemSerialNo = itemSerialNo;
        this.materialsCategory = materialsCategory;
        this.itemStatus = itemStatus;
        this.subdivisionUnit = subdivisionUnit;
        this.subdivisionYN = subdivisionYN;
        this.itemPrice = itemPrice;
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

    public MaterialsCategoryDTO getMaterialsCategory() {
        return materialsCategory;
    }

    public void setMaterialsCategory(MaterialsCategoryDTO materialsCategory) {
        this.materialsCategory = materialsCategory;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Integer getSubdivisionUnit() {
        return subdivisionUnit;
    }

    public void setSubdivisionUnit(Integer subdivisionUnit) {
        this.subdivisionUnit = subdivisionUnit;
    }

    public String getSubdivisionYN() {
        return subdivisionYN;
    }

    public void setSubdivisionYN(String subdivisionYN) {
        this.subdivisionYN = subdivisionYN;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "MaterialsDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemSerialNo='" + itemSerialNo + '\'' +
                ", materialsCategory=" + materialsCategory +
                ", itemStatus='" + itemStatus + '\'' +
                ", subdivisionUnit=" + subdivisionUnit +
                ", subdivisionYN='" + subdivisionYN + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }


}
