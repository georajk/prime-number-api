package com.codergk.primenumber.controller;

import com.codergk.primenumber.json.PrimeNumberJson;
import com.codergk.primenumber.service.PrimeNumberService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class RestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private PrimeNumberService primeNumberService;


    @Test
    void getPrimeNumbers() throws Exception {
        PrimeNumberJson primeNumberJson = new PrimeNumberJson();

        primeNumberJson.setMaxNumber(10);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);

        primeNumberJson.setPrimeNumberList(new ArrayList<>());


        Mockito.when(primeNumberService.getPrimeNumbers("10")).thenReturn(primeNumberJson);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/primeNumbers?value=10")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$.primeNumberList").isArray())
               .andExpect(jsonPath("$.maxNumber", Matchers.is(10))).andDo(print());
    }
}
