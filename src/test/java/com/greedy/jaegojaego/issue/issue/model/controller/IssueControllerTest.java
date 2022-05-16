package com.greedy.jaegojaego.issue.issue.model.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.issue.issue.model.service.IssueService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class})
@AutoConfigureMockMvc
class IssueControllerTest {

    @Autowired
    private IssueService issueService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("이슈 상세 조회 비동기 테스트")
    public void selectIssueDetail() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/issue/detail")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("issueNo", "1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("이슈 삭제 비동기 테스트")
    @Transactional
    public void removeIssue() throws Exception {

        int removeIssueNo = 81;

        String content = objectMapper.writeValueAsString(removeIssueNo);

        mockMvc.perform(post("/issue/remove")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("\"success\""))
                .andDo(print());


    }

}