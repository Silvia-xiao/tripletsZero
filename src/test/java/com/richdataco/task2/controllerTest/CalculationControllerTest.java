package com.richdataco.task2.controllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CalculationControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testTripletsZero() throws Exception {
        int arr[] = {0, -1, 2, -3, 1, 1};
        String inputString = Arrays.toString(arr);
        mockMvc.perform(post("http://localhost:8080/calculate")
                .content(inputString))
                .andExpect(status().isOk());
    }

    @Test
    public void testTripletsZero_badRequest() throws Exception {
        mockMvc.perform(post("http://localhost:8080/calculate")
                .content(""))
                .andExpect(status().isBadRequest());
    }
}



