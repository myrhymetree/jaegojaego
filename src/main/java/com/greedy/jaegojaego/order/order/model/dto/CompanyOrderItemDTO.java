package com.greedy.jaegojaego.order.order.model.dto;

<<<<<<< HEAD:src/main/java/com/greedy/jaegojaego/order/model/dto/CompanyOrderItemDTO.java
=======
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;
>>>>>>> origin/feature/order:src/main/java/com/greedy/jaegojaego/order/order/model/dto/CompanyOrderItemDTO.java
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyOrderItemDTO {

    private OrderItemInfoDTO itemInfo;
    private CompanyOrderHistoryDTO companyOrderHistory;
    private int companyOrderItemAmount;

    @Override
    public String toString() {
        return "CompanyOrderItemDTO{" +
                "itemInfo=" + itemInfo +
                ", companyOrderItemAmount=" + companyOrderItemAmount +
                '}';
    }
}
