package ru.tinkoff.contactapplicationapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.exception.JDBCConnectionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import ru.tinkoff.contactapplicationapi.exception.ApplicationsNotFoundException;
import ru.tinkoff.contactapplicationapi.exception.ContactNotFoundException;
import ru.tinkoff.contactapplicationapi.model.*;
import ru.tinkoff.contactapplicationapi.service.ContactApplicationService;

import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactApplicationControllerTest {

    private static final String CONTACT_ID = "1";

    private MockMvc mockMvc;

    @MockBean
    private ContactApplicationService service;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getContactApplication_success() throws Exception {
        Response response = new SuccessResponse(true);
        when(service.process(anyLong())).thenReturn(response);

        MvcResult result = mockMvc.perform(get("/contact/" + CONTACT_ID + "/application")).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

        Response successResponse = objectMapper.readValue(result.getResponse().getContentAsString(), SuccessResponse.class);

        Assert.assertTrue(successResponse.isSuccess());
    }

    @Test
    public void getContactApplication_errorContactNotFound() throws Exception {
        ContactNotFoundException exception = new ContactNotFoundException();
        Mockito.when(service.process(anyLong())).thenThrow(exception);

        MvcResult result = mockMvc.perform(get("/contact/" + CONTACT_ID + "/application")).andReturn();

        ErrorResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), ErrorResponse.class);

        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
        Assert.assertFalse(response.isSuccess());
        Assert.assertNotNull(response.getError());

    }

    @Test
    public void getContactApplication_errorApplicationsNotFound() throws Exception {
        ApplicationsNotFoundException exception = new ApplicationsNotFoundException();
        Mockito.when(service.process(anyLong())).thenThrow(exception);

        MvcResult result = mockMvc.perform(get("/contact/" + CONTACT_ID + "/application")).andReturn();

        ErrorResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), ErrorResponse.class);

        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
        Assert.assertFalse(response.isSuccess());
        Assert.assertNotNull(response.getError());
    }

    @Test
    public void getContactApplication_errorIllegalArgument() throws Exception {
        IllegalArgumentException exception = new IllegalArgumentException();
        Mockito.when(service.process(anyLong())).thenThrow(exception);

        MvcResult result = mockMvc.perform(get("/contact/" + CONTACT_ID + "/application")).andReturn();

        ErrorResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), ErrorResponse.class);

        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
        Assert.assertFalse(response.isSuccess());
        Assert.assertNotNull(response.getError());
    }

    @Test
    public void getContactApplication_errorJDBC() throws Exception {
        JDBCConnectionException exception = new JDBCConnectionException("error", new SQLException());
        Mockito.when(service.process(anyLong())).thenThrow(exception);

        MvcResult result = mockMvc.perform(get("/contact/" + CONTACT_ID + "/application")).andReturn();

        ErrorResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), ErrorResponse.class);

        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), result.getResponse().getStatus());
        Assert.assertFalse(response.isSuccess());
        Assert.assertNotNull(response.getError());
    }
}