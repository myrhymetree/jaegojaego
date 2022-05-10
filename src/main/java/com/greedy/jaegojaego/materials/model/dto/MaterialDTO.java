package com.greedy.jaegojaego.materials.model.dto;

public class MaterialDTO {

    private FranchiseOrderableItemDTO franchiseOrderableItem;      //자재 번호
    private String itemInfoName;                       //자재 품명
    private String itemSerialNo;                       //자재 품번
    private MaterialsCategoryDTO materialsCategory;    //자재 카테고리
    private String itemStatus;                         //자재 삭제 상태
    private Integer subdivisionUnit;                   //자재 소분
    private String subdivisionYN;                      //자재 가공 유무

    public MaterialDTO() {
    }

    public MaterialDTO(FranchiseOrderableItemDTO franchiseOrderableItem, String itemInfoName, String itemSerialNo, MaterialsCategoryDTO materialsCategory, String itemStatus, Integer subdivisionUnit, String subdivisionYN) {
        this.franchiseOrderableItem = franchiseOrderableItem;
        this.itemInfoName = itemInfoName;
        this.itemSerialNo = itemSerialNo;
        this.materialsCategory = materialsCategory;
        this.itemStatus = itemStatus;
        this.subdivisionUnit = subdivisionUnit;
        this.subdivisionYN = subdivisionYN;
    }

    public FranchiseOrderableItemDTO getFranchiseOrderableItem() {
        return franchiseOrderableItem;
    }

    public void setFranchiseOrderableItem(FranchiseOrderableItemDTO franchiseOrderableItem) {
        this.franchiseOrderableItem = franchiseOrderableItem;
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

    @Override
    public String toString() {
        return "MaterialDTO{" +
                "franchiseOrderableItem=" + franchiseOrderableItem +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemSerialNo='" + itemSerialNo + '\'' +
                ", materialsCategory=" + materialsCategory +
                ", itemStatus='" + itemStatus + '\'' +
                ", subdivisionUnit=" + subdivisionUnit +
                ", subdivisionYN='" + subdivisionYN + '\'' +
                '}';
    }
}
