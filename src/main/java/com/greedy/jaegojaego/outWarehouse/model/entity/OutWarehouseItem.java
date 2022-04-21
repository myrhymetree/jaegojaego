package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "OutWarehouseItem")
@Table(name = "OUT_WAREHOUSE_ITEM")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_ITEM_NO_SEQ_GENERATOR",
        sequenceName = "OUT_WAREHOUSE_ITEM_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OutWarehouseItem {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_ITEM_NO_SEQ_GENERATOR"
    )
    @JoinColumn(name = "OUT_WAREHOUSE_ITEM_NO")
    private int outWarehouseItemNo;

    @ManyToOne
    @JoinColumn(name = "OUT_WAREHOUSE_NO")
    private OutWarehouse outWarehouseNo;

    @ManyToOne
    @JoinColumn(name = "ITEM_WAREHOUSE_NO")
    private OutWarehouseItemWarehouse itemWarehouseNo;

    @Column(name = "OUT_WAREHOUSE_ITEM_AMOUNT")
    private int outWarehouseItemAmount;

    public OutWarehouseItem() {}

    public OutWarehouseItem(int outWarehouseItemNo, OutWarehouse outWarehouseNo, OutWarehouseItemWarehouse itemWarehouseNo, int outWarehouseItemAmount) {
        this.outWarehouseItemNo = outWarehouseItemNo;
        this.outWarehouseNo = outWarehouseNo;
        this.itemWarehouseNo = itemWarehouseNo;
        this.outWarehouseItemAmount = outWarehouseItemAmount;
    }

    public int getOutWarehouseItemNo() {
        return outWarehouseItemNo;
    }

    public OutWarehouse getOutWarehouseNo() {
        return outWarehouseNo;
    }

    public OutWarehouseItemWarehouse getItemWarehouseNo() {
        return itemWarehouseNo;
    }

    public int getOutWarehouseItemAmount() {
        return outWarehouseItemAmount;
    }

    public void setOutWarehouseItemNo(int outWarehouseItemNo) {
        this.outWarehouseItemNo = outWarehouseItemNo;
    }

    public void setOutWarehouseNo(OutWarehouse outWarehouseNo) {
        this.outWarehouseNo = outWarehouseNo;
    }

    public void setItemWarehouseNo(OutWarehouseItemWarehouse itemWarehouseNo) {
        this.itemWarehouseNo = itemWarehouseNo;
    }

    public void setOutWarehouseItemAmount(int outWarehouseItemAmount) {
        this.outWarehouseItemAmount = outWarehouseItemAmount;
    }

    @Override
    public String toString() {
        return "OutWarehouseItem{" +
                "outWarehouseItemNo=" + outWarehouseItemNo +
                ", outWarehouseNo=" + outWarehouseNo +
                ", itemWarehouseNo=" + itemWarehouseNo +
                ", outWarehouseItemAmount=" + outWarehouseItemAmount +
                '}';
    }
}
