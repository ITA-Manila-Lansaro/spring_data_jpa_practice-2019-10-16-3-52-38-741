package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Prosecutor;
import com.tw.apistackbase.repository.ProsecutorRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProsecutorController.class)
@ActiveProfiles(profiles = "test")
class ProsecutorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProsecutorRepo prosecutorRepo;

    private List<Prosecutor> prosecutorList = new ArrayList<>();

    @Test
    void should_return_all_prosecutors_when_getAll_is_called() throws Exception {
        prosecutorList.add(new Prosecutor());
        prosecutorList.add(new Prosecutor());
        when(prosecutorRepo.findAll()).thenReturn(prosecutorList);

        ResultActions result = mvc.perform(get("/api/prosecutors"));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());

    }
}