package com.greedy.jaegojaego.order.order.model.service;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.order.order.model.entitiy.CompanyOrderHistory;
import com.greedy.jaegojaego.order.order.model.repository.CompanyOrderHistoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JaegojaegoApplication.class})
@AutoConfigureMockMvc
public class OrderServiceTests {

    @Autowired
    private CompanyOrderHistoryRepository companyOrderHistoryRepository;

    @Test
    @DisplayName("본사 발주 내역 상세 조회 레포지토리 메소드 테스트")
    public void selectCompanyOrderHistoryDetail() {

        //given
        int companyOrderHistoryNo = 1;

        //when
        CompanyOrderHistory companyOrderHistory = companyOrderHistoryRepository.findById(companyOrderHistoryNo).get();

        //then
        assertNotNull(companyOrderHistory);

    }

}
