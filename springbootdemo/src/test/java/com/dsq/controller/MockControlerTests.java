package com.dsq.controller;

import com.dsq.dao.UserRepository;
import com.dsq.entity.User;
import com.dsq.service.impl.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

/**
 * Created by DELL on 2018/12/5.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
public class MockControlerTests {
    private MockMvc mvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Before
    public void setUp() throws Exception {
//        mvc = MockMvcBuilders.standaloneSetup(new MockController()).build();
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象

    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/mock/get").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void postHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/mock/post").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/mock/user?username=qwert"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void user() throws Exception {
        User softInfo = new User();
        softInfo.setUsername("dong");
        //设置值
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(softInfo);
        mvc.perform(MockMvcRequestBuilders.post("/mock/user")
//                .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void formuser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/mock/formuser")
                .param("username", "dongshui")
                .param("password", "password")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)

        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void rollback() throws Exception {
        User user = new User();
        user.setUsername("aa");
        user.setPassword("bb");
        user.setEmail("email");
        user.setRegTime("awer");
        userRepository.save(user);
    }

    @Test
    public void rollback2() throws Exception {
        User user = new User();
        user.setUsername("aa2");
        user.setPassword("bb");
        user.setEmail("email2");
        user.setRegTime("awer");
        userService.save(user);
    }

}