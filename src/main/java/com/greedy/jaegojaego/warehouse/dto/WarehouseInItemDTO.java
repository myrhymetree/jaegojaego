package com.greedy.jaegojaego.warehouse.dto;

import java.sql.Date;

public class WarehouseInItemDTO {           //상세 조회를 하기 위한 정보를 담은 DTO
//  거래처명, 발주한 (품목, 품번, 품명, 주문수량)

    private String warehouseClientName;             //거래처명
    private String warehouseMaterialCategoryName;   //품목
    private String warehouseItemInfoItemSerialNo;   //품번
    private String warehouseItemInfoName;           //품명
    private int warehouseCompanyOrderItemAmount;    //주문수량
    private java.sql.Date warehouseOrderDate;       //발주 일자
    private int warehouseNo;                        //입고 번호
    private String warehouseWorkingStatus;          //작업 상태
    private java.sql.Date warehouseDate;            //작업 처리일자
    private int warehouseCheckAmount;               //입하 수량(상태 변경이력의 입고 처리 상태 수량 in warehouse status history)
    private int warehouseInAmount;                  //입고 수량(창고의 수량 item_warehouse)

    public WarehouseInItemDTO() {}

    public WarehouseInItemDTO(String warehouseClientName, String warehouseMaterialCategoryName, String warehouseItemInfoItemSerialNo, String warehouseItemInfoName, int warehouseCompanyOrderItemAmount, Date warehouseOrderDate, int warehouseNo, String warehouseWorkingStatus, Date warehouseDate, int warehouseCheckAmount, int warehouseInAmount) {
        this.warehouseClientName = warehouseClientName;
        this.warehouseMaterialCategoryName = warehouseMaterialCategoryName;
        this.warehouseItemInfoItemSerialNo = warehouseItemInfoItemSerialNo;
        this.warehouseItemInfoName = warehouseItemInfoName;
        this.warehouseCompanyOrderItemAmount = warehouseCompanyOrderItemAmount;
        this.warehouseOrderDate = warehouseOrderDate;
        this.warehouseNo = warehouseNo;
        this.warehouseWorkingStatus = warehouseWorkingStatus;
        this.warehouseDate = warehouseDate;
        this.warehouseCheckAmount = warehouseCheckAmount;
        this.warehouseInAmount = warehouseInAmount;
    }

    public String getWarehouseClientName() {
        return warehouseClientName;
    }

    public void setWarehouseClientName(String warehouseClientName) {
        this.warehouseClientName = warehouseClientName;
    }

    public String getWarehouseMaterialCategoryName() {
        return warehouseMaterialCategoryName;
    }

    public void setWarehouseMaterialCategoryName(String warehouseMaterialCategoryName) {
        this.warehouseMaterialCategoryName = warehouseMaterialCategoryName;
    }

    public String getWarehouseItemInfoItemSerialNo() {
        return warehouseItemInfoItemSerialNo;
    }

    public void setWarehouseItemInfoItemSerialNo(String warehouseItemInfoItemSerialNo) {
        this.warehouseItemInfoItemSerialNo = warehouseItemInfoItemSerialNo;
    }

    public String getWarehouseItemInfoName() {
        return warehouseItemInfoName;
    }

    public void setWarehouseItemInfoName(String warehouseItemInfoName) {
        this.warehouseItemInfoName = warehouseItemInfoName;
    }

    public int getWarehouseCompanyOrderItemAmount() {
        return warehouseCompanyOrderItemAmount;
    }

    public void setWarehouseCompanyOrderItemAmount(int warehouseCompanyOrderItemAmount) {
        this.warehouseCompanyOrderItemAmount = warehouseCompanyOrderItemAmount;
    }

    public Date getWarehouseOrderDate() {
        return warehouseOrderDate;
    }

    public void setWarehouseOrderDate(Date warehouseOrderDate) {
        this.warehouseOrderDate = warehouseOrderDate;
    }

    public int getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(int warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public String getWarehouseWorkingStatus() {
        return warehouseWorkingStatus;
    }

    public void setWarehouseWorkingStatus(String warehouseWorkingStatus) {
        this.warehouseWorkingStatus = warehouseWorkingStatus;
    }

    public Date getWarehouseDate() {
        return warehouseDate;
    }

    public void setWarehouseDate(Date warehouseDate) {
        this.warehouseDate = warehouseDate;
    }

    public int getWarehouseCheckAmount() {
        return warehouseCheckAmount;
    }

    public void setWarehouseCheckAmount(int warehouseCheckAmount) {
        this.warehouseCheckAmount = warehouseCheckAmount;
    }

    public int getWarehouseInAmount() {
        return warehouseInAmount;
    }

    public void setWarehouseInAmount(int warehouseInAmount) {
        this.warehouseInAmount = warehouseInAmount;
    }

    @Override
    public String toString() {
        return "WarehouseInItemDTO{" +
                "warehouseClientName='" + warehouseClientName + '\'' +
                ", warehouseMaterialCategoryName='" + warehouseMaterialCategoryName + '\'' +
                ", warehouseItemInfoItemSerialNo='" + warehouseItemInfoItemSerialNo + '\'' +
                ", warehouseItemInfoName='" + warehouseItemInfoName + '\'' +
                ", warehouseCompanyOrderItemAmount=" + warehouseCompanyOrderItemAmount +
                ", warehouseOrderDate=" + warehouseOrderDate +
                ", warehouseNo=" + warehouseNo +
                ", warehouseWorkingStatus='" + warehouseWorkingStatus + '\'' +
                ", warehouseDate=" + warehouseDate +
                ", warehouseCheckAmount=" + warehouseCheckAmount +
                ", warehouseInAmount=" + warehouseInAmount +
                '}';
    }
}
