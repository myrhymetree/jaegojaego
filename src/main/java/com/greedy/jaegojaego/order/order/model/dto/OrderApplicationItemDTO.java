package com.greedy.jaegojaego.order.order.model.dto;


<<<<<<< HEAD:src/main/java/com/greedy/jaegojaego/order/model/dto/OrderApplicationItemDTO.java
=======
import com.greedy.jaegojaego.order.client.model.dto.OrderClientContractItemDTO;
>>>>>>> origin/feature/order:src/main/java/com/greedy/jaegojaego/order/order/model/dto/OrderApplicationItemDTO.java
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderApplicationItemDTO {

    private OrderApplicationDTO orderApplication;
    private int orderApplicationItemAmount;
    private OrderClientContractItemDTO clientContractItem;

    @Override
    public String toString() {
        return "OrderApplicationItemDTO{" +
                "orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", clientContractItem=" + clientContractItem +
                '}';
    }
}
