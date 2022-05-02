package com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog;

public class BacklogItemWarehouseDTO {
    private int itemWarehouseNo; //자재창고번호pk
    private BacklogItemInfoDTO itemInfoNo; //자재번호(fk)
    private BacklogInWarehouseDTO inWarehouseNoForItemWarehouse; //입고구분번호}(fk)

    public BacklogItemWarehouseDTO() {}

    public BacklogItemWarehouseDTO(int itemWarehouseNo, BacklogItemInfoDTO itemInfoNo, BacklogInWarehouseDTO inWarehouseNoForItemWarehouse) {
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

    public BacklogItemInfoDTO getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(BacklogItemInfoDTO itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public BacklogInWarehouseDTO getInWarehouseNoForItemWarehouse() {
        return inWarehouseNoForItemWarehouse;
    }

    public void setInWarehouseNoForItemWarehouse(BacklogInWarehouseDTO inWarehouseNoForItemWarehouse) {
        this.inWarehouseNoForItemWarehouse = inWarehouseNoForItemWarehouse;
    }

    @Override
    public String toString() {
        return "BacklogItemWarehouseDTO{" +
                "itemWarehouseNo=" + itemWarehouseNo +
                ", itemInfoNo=" + itemInfoNo +
//                ", inWarehouseNoForItemWarehouse=" + inWarehouseNoForItemWarehouse +
                '}';
    }
}

