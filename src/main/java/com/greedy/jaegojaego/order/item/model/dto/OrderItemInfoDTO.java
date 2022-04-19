package com.greedy.jaegojaego.order.item.model.dto;

import com.greedy.jaegojaego.materials.model.dto.OrderMateiralCategoryDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemInfoDTO {

    private int itemInfoNo;
    private String itemInfoName;
    private String itemInfoItemSerialNo;
    private OrderMateiralCategoryDTO materialCategory;
    private String itemInfoStatusYn;

    @Override
    public String toString() {
        return "ItemInfoDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoItemSerialNo='" + itemInfoItemSerialNo + '\'' +
                ", materialCategory=" + materialCategory +
                ", itemInfoStatusYn='" + itemInfoStatusYn + '\'' +
                '}';
    }
}
