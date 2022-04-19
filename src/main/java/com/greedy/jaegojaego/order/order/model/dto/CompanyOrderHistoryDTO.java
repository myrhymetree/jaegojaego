package com.greedy.jaegojaego.order.order.model.dto;

<<<<<<< HEAD:src/main/java/com/greedy/jaegojaego/order/model/dto/CompanyOrderHistoryDTO.java
=======
import com.greedy.jaegojaego.order.company.model.dto.OrderCompanyAccountDTO;
>>>>>>> origin/feature/order:src/main/java/com/greedy/jaegojaego/order/order/model/dto/CompanyOrderHistoryDTO.java
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyOrderHistoryDTO {

    private int companyOrderHistoryNo;
    private java.sql.Date companyOrderHistoryCreatedDate;
    private OrderCompanyAccountDTO companyAccount;
    private List<CompanyOrderItemDTO> companyOrderItemList;
    private List<OrderApplicationDTO> orderApplicationList;

    @Override
    public String toString() {
        return "CompanyOrderHistoryDTO{" +
                "companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", companyOrderHistoryCreatedDate=" + companyOrderHistoryCreatedDate +
                ", companyAccount=" + companyAccount +
                ", companyOrderItemList=" + companyOrderItemList +
                ", orderApplicationList=" + orderApplicationList +
                '}';
    }
}
