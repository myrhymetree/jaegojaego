package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Materials")
@Table(name = "ITEM_INFO")
@SequenceGenerator(
        name = "ITEM_SEQ_GENERATOR",
        sequenceName = "ITEM_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
public class Materials implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_SEQ_GENERATOR"
    )
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    /*@OneToMany
    @JoinColumn(name = "조회올것")
    private List<FranchiseOrderableItem> franchiseOrderableItem;*/
    //리팩토링 해야하니 나중에 다시 할 것

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @Column(name = "ITEM_INFO_ITEM_SERIAL_NO")
    private String itemSerialNo;

    @ManyToOne
    @JoinColumn(name = "MATERIAL_CATEGORY_NO")
    private MaterialsCategory materialCategory;

    @Column(name = "SUBDIVISION_UNIT")
    private Integer subdivisionUnit;

    @Column(name = "SUBDIVISION_YN")
    private String subdivisionYN;

    @Column(name = "ITEM_INFO_STATUS_YN")
    private String itemStatus;

    @Column(name = "FRANCHISE_ORDERABLE_ITEM_PRICE")
    private int itemPrice;

    public Materials() {
    }

    public Materials(int itemInfoNo, String itemInfoName, String itemSerialNo, MaterialsCategory materialCategory, Integer subdivisionUnit, String subdivisionYN, String itemStatus, int itemPrice) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemSerialNo = itemSerialNo;
        this.materialCategory = materialCategory;
        this.subdivisionUnit = subdivisionUnit;
        this.subdivisionYN = subdivisionYN;
        this.itemStatus = itemStatus;
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

    public MaterialsCategory getMaterialCategory() {
        return materialCategory;
    }

    public void setMaterialCategory(MaterialsCategory materialCategory) {
        this.materialCategory = materialCategory;
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

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemSerialNo='" + itemSerialNo + '\'' +
                ", materialCategory=" + materialCategory +
                ", subdivisionUnit=" + subdivisionUnit +
                ", subdivisionYN='" + subdivisionYN + '\'' +
                ", itemStatus='" + itemStatus + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
