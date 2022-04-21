package com.greedy.jaegojaego.order.material.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderMaterialCategoryDTO {

    private int materialCategoryNo;
    private String materialCategoryName;

    @Override
    public String toString() {
        return "OrderMaterialCategoryDTO{" +
                "materialCategoryNo=" + materialCategoryNo +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
