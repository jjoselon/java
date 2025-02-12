package com.interview.springbootinterview.springbeanscontainer.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.interview.springbootinterview.springbeanscontainer.beans.RepositoryDTO;
import com.interview.springbootinterview.springbeanscontainer.beans.Transporte;
import com.interview.springbootinterview.springbeanscontainer.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @MockBean
    private RepositoryDTO repositoryDTO;

    @MockBean
    private User user;

    @MockBean
    private Transporte vehiculo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testQualifierEndpoint() throws Exception {

        given(vehiculo.getMarca()).willReturn("BMW");

        mockMvc.perform(get("/qualifier")).
                andExpect(status().isOk()).
                andExpect(content().string("ricachon"));
    }
}
