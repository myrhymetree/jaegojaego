package com.greedy.jaegojaego.order.item.model.entity;

import com.greedy.jaegojaego.order.material.model.entity.OrderMaterialCategory;
import lombok.*;

import javax.persistence.*;

@Entity(name = "orderItemInfo")
@Table(name = "ITEM_INFO")
@SequenceGenerator(
        name = "ITEM_INFO_SEQ_GENERATOR",
        sequenceName = "ITEM_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OrderItemInfo {

    @Id
    @Column(name = "ITEM_INFO_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_INFO_SEQ_GENERATOR"
    )
    private int itemInfoNo;

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @Column(name = "ITEM_INFO_ITEM_SERIAL_NO")
    private String itemInfoItemSerialNo;

    @ManyToOne
    @JoinColumn(name = "MATERIAL_CATEGORY_NO")
    private OrderMaterialCategory orderMaterialCategory;

    @Column(name = "ITEM_INFO_STATUS_YN")
    private String itemInfoStatusYn;

    public OrderItemInfo() {
    }

    public OrderItemInfo(int itemInfoNo, String itemInfoName, String itemInfoItemSerialNo, OrderMaterialCategory orderMaterialCategory, String itemInfoStatusYn) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
        this.orderMaterialCategory = orderMaterialCategory;
        this.itemInfoStatusYn = itemInfoStatusYn;
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

    public OrderMaterialCategory getOrderMaterialCategory() {
        return orderMaterialCategory;
    }

    public void setOrderMaterialCategory(OrderMaterialCategory orderMaterialCategory) {
        this.orderMaterialCategory = orderMaterialCategory;
    }

    public String getItemInfoStatusYn() {
        return itemInfoStatusYn;
    }

    public void setItemInfoStatusYn(String itemInfoStatusYn) {
        this.itemInfoStatusYn = itemInfoStatusYn;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoItemSerialNo='" + itemInfoItemSerialNo + '\'' +
                ", materialCategory=" + orderMaterialCategory +
                ", itemInfoStatusYn='" + itemInfoStatusYn + '\'' +
                '}';
    }
}
