package com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogInWarehouseDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogItemInfoDTO;

import javax.persistence.*;

@Entity(name = "BacklogItemWarehouseEntity")
@Table(name = "ITEM_WAREHOUSE")
public class BacklogItemWarehouse {

    @Id
    @Column(name = "ITEM_WAREHOUSE_NO")
    private int itemWarehouseNo;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private BacklogItemInfo itemInfoNo;

    @ManyToOne
    @JoinColumn(name = "IN_WAREHOUSE_NO")
    private BacklogInWarehouse inWarehouseNoForItemWarehouse;

    public BacklogItemWarehouse() {}

    public BacklogItemWarehouse(int itemWarehouseNo, BacklogItemInfo itemInfoNo, BacklogInWarehouse inWarehouseNoForItemWarehouse) {
        this.itemWarehouseNo = itemWarehouseNo;
        this.itemInfoNo = itemInfoNo;
        this.inWarehouseNoForItemWarehouse = inWarehouseNoForItemWarehouse;
    }

    public int getItemWarehouseNo() {
        return itemWarehouseNo;
    }

    public void setItemWarehouseNo(int itemWarehouseNo) {
        this.itemWarehouseNo = itemWarehouseNo;
    }

    public BacklogItemInfo getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(BacklogItemInfo itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public BacklogInWarehouse getInWarehouseNoForItemWarehouse() {
        return inWarehouseNoForItemWarehouse;
    }

    public void setInWarehouseNoForItemWarehouse(BacklogInWarehouse inWarehouseNoForItemWarehouse) {
        this.inWarehouseNoForItemWarehouse = inWarehouseNoForItemWarehouse;
    }

    @Override
    public String toString() {
        return "BacklogItemWarehouse{" +
                "itemWarehouseNo=" + itemWarehouseNo +
                ", itemInfoNo=" + itemInfoNo +
//                ", inWarehouseNoForItemWarehouse=" + inWarehouseNoForItemWarehouse +
                '}';
    }
}
