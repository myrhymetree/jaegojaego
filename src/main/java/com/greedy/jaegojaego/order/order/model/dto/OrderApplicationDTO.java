package com.greedy.jaegojaego.order.order.model.dto;

<<<<<<< HEAD:src/main/java/com/greedy/jaegojaego/order/model/dto/OrderApplicationDTO.java
=======
import com.greedy.jaegojaego.order.client.model.dto.OrderClientDTO;
>>>>>>> origin/feature/order:src/main/java/com/greedy/jaegojaego/order/order/model/dto/OrderApplicationDTO.java
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderApplicationDTO {

    private CompanyOrderHistoryDTO companyOrderHistory;
    private int orderApplicationNo;
    private OrderClientDTO client;
    private List<OrderApplicationItemDTO> orderApplicationItemList;

    @Override
    public String toString() {
        return "OrderApplicationDTO{" +
                "orderApplicationNo=" + orderApplicationNo +
                ", client=" + client +
                ", orderApplicationItemList=" + orderApplicationItemList +
                '}';
    }
}
