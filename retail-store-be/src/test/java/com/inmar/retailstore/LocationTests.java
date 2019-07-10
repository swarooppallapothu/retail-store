package com.inmar.retailstore;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = RetailStoreApplication.class)
@ActiveProfiles({"test", "dev"})
public class LocationTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private static final String ENTITY = "/api/location";

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    @Before
    public void contextLoads() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void test_all_locations() throws Exception {
        mockMvc.perform(get(ENTITY + "/all")
                .accept(CONTENT_TYPE))
                .andExpect(jsonPath("$.data", Matchers.hasSize(0)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
