package com.olgasemenova.mirowidgets.controller;

import com.olgasemenova.mirowidgets.repository.WidgetRepository;

import com.olgasemenova.mirowidgets.service.WidgetService;
import com.olgasemenova.mirowidgets.util.WidgetMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class WidgetControllerTest {

    @InjectMocks
    private WidgetController widgetController;

    @Mock
    private WidgetService widgetService;

    @Mock
    private static WidgetRepository widgetRepository;

    @Mock
    private WidgetMapper widgetMapper;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(widgetController).build();
    }

    @Test
    void getWidgets() throws Exception{
        mockMvc.perform(get("/api/v1/widget")).andExpect(status().isOk());
    }
}