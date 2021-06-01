package com.azurealstn.codespringweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@WebAppConfiguration
@SpringBootTest
public class BoardControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception {
        log.info("list url: " +
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                .andReturn()
                .getModelAndView()
                .getModelMap()
        );
    }

    @Test
    public void testRegister() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
            .param("title", "테스트 새글 제목")
            .param("content", "테스트 새글 내용")
            .param("writer", "테스트 새저자 내용")
        ).andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }

    @Test
    public void testGet() throws Exception {
        log.info("/board/get" + mockMvc.perform(MockMvcRequestBuilders
            .get("/board/get")
            .param("bno", "4"))
            .andReturn()
            .getModelAndView().getModelMap());
    }

    @Test
    public void testModify() throws Exception {
        String resultPage =  mockMvc
                .perform(MockMvcRequestBuilders.post("/board/modify")
                    .param("bno", "1")
                    .param("title", "수정합니다. 제목")
                    .param("content", "수정합니다. 내용")
                    .param("writer", "수정합니다. 저자"))
                .andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }

    @Test
    public void testRemove() throws Exception {
        String resultPage = mockMvc
                .perform(MockMvcRequestBuilders.post("/board/remove")
                    .param("bno", "1"))
                .andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }
}
