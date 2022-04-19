package com.greedy.jaegojaego.materials.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderMateiralCategoryDTO {

    private int materialCategoryNo;
    private String materialCategoryName;

    @Override
    public String toString() {
        return "MateiralCategoryDTO{" +
                "materialCategoryNo=" + materialCategoryNo +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
