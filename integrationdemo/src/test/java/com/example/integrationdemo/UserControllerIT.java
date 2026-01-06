package com.example.integrationdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UserControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createUserIntegrationTest() throws Exception {
        mockMvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content("""
                    {
                      "username": "saloni",
                      "password": "1234"
                    }
                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("saloni"));
    }
}
