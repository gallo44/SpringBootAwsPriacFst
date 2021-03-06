package com.jojoldu.book.springboot;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Junit에 내장된 실횅자 외에 다른 실행자를 실행시킴
// 스프링 부트 테스트와 Junit 사이에 연결자 역할을 함
@RunWith(SpringRunner.class)
// Web에 집중할 수 있는 어노테이션
// Controller, ControllerAdvice 선언 가능
// Service, Component, Repository 선언 불가능
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    // 스프링이 관리하는 빈 주입 받음;
    @Autowired
    // 웹 API를 테스틓할 때 사용
    // 스프링 MVC 테스트의 시작점
    // 이 클래스를 통해 Http Get, post등에 대한 API 테스트 가능
    private MockMvc mvc;

    @Test
    public void returnHello() throws Exception {
        String hello = "hello";

        // MockMvc를 통해 hello를 주소로 Http Get 요청
        // Http Header으이 스테터스 검증
        // 200,4040,500 검증
        // 200인지 아닌지 검증

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void returnHelloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect((jsonPath("$.amount", is(amount))));
    }
}
