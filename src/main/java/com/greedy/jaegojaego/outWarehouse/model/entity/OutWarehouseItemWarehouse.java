package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "OutWarehouseItemWarehouse")
@Table(name = "ITEM_WAREHOUSE")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_ITEM_WAREHOUSE_SEQ_GENERATOR",
        sequenceName = "ITEM_WAREHOUSE_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OutWarehouseItemWarehouse {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_ITEM_WAREHOUSE_SEQ_GENERATOR"
    )
    @Column(name = "ITEM_WAREHOUSE_NO")
    private int itemWarehouseNo;

    @Column(name = "ITEM_WAREHOUSE_DIVISION")
    private String itemWarehouseDivision;

    @Column(name = "ITEM_WAREHOUSE_AMOUNT")
    private int itemWarehouseAmount;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OutWarehouseMaterials itemInfoNo;

    @ManyToOne
    @JoinColumn(name = "OUT_WAREHOUSE_NO")
    private OutWarehouse outWarehouseNo;

    public OutWarehouseItemWarehouse() {}

    public OutWarehouseItemWarehouse(int itemWarehouseNo, String itemWarehouseDivision, int itemWarehouseAmount, OutWarehouseMaterials itemInfoNo, OutWarehouse outWarehouseNo) {
        this.itemWarehouseNo = itemWarehouseNo;
        this.itemWarehouseDivision = itemWarehouseDivision;
        this.itemWarehouseAmount = itemWarehouseAmount;
        this.itemInfoNo = itemInfoNo;
        this.outWarehouseNo = outWarehouseNo;
    }

    public int getItemWarehouseNo() {
        return itemWarehouseNo;
    }

    public String getItemWarehouseDivision() {
        return itemWarehouseDivision;
    }

    public int getItemWarehouseAmount() {
        return itemWarehouseAmount;
    }

    public OutWarehouseMaterials getItemInfoNo() {
        return itemInfoNo;
    }

    public OutWarehouse getOutWarehouseNo() {
        return outWarehouseNo;
    }

    public void setItemWarehouseNo(int itemWarehouseNo) {
        this.itemWarehouseNo = itemWarehouseNo;
    }

    public void setItemWarehouseDivision(String itemWarehouseDivision) {
        this.itemWarehouseDivision = itemWarehouseDivision;
    }

    public void setItemWarehouseAmount(int itemWarehouseAmount) {
        this.itemWarehouseAmount = itemWarehouseAmount;
    }

    public void setItemInfoNo(OutWarehouseMaterials itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public void setOutWarehouseNo(OutWarehouse outWarehouseNo) {
        this.outWarehouseNo = outWarehouseNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseItemWarehouse{" +
                "itemWarehouseNo=" + itemWarehouseNo +
                ", itemWarehouseDivision='" + itemWarehouseDivision + '\'' +
                ", itemWarehouseAmount=" + itemWarehouseAmount +
                ", itemInfoNo=" + itemInfoNo +
                ", outWarehouseDivisionNo=" + outWarehouseNo +
                '}';
    }
}
