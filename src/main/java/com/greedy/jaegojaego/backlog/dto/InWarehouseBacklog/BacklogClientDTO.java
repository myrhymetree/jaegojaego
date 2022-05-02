package com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog;

public class BacklogClientDTO {
    private int clientNo;
    private String clientName;

    public BacklogClientDTO() {}

    public BacklogClientDTO(int clientNo, String clientName) {
        this.clientNo = clientNo;
        this.clientName = clientName;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "BacklogClientDTO{" +
                "clientNo=" + clientNo +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
