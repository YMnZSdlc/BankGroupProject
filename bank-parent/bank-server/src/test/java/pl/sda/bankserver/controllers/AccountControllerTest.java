package pl.sda.bankserver.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.sda.bankcommons.domain.dtos.AccountRegistrationDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTest {

    @Autowired
    WebApplicationContext context;

    @Autowired
    private ObjectMapper mapper;

    private AccountRegistrationDto creationDto1;
    private AccountRegistrationDto creationDto2;
    private AccountRegistrationDto creationDto3;

    @Before
    public void setup1() {
        creationDto1 = AccountRegistrationDto.builder()
                .id(1)
                .number("92114000004170191394451790")
                .createDate(LocalDateTime.of(2015, Month.JANUARY, 1, 10, 10, 30))
                .balance(new BigDecimal(1000000))
                .build();

        creationDto2 = AccountRegistrationDto.builder()
                .id(2)
                .number("88188000098916155367111982")
                .createDate(LocalDateTime.of(2017, Month.JANUARY, 1, 7, 0, 0))
                .balance(new BigDecimal(1700000))
                .build();

        creationDto3 = AccountRegistrationDto.builder()
                .id(3)
                .number("78188000094662356817820269")
                .createDate(LocalDateTime.of(2013, Month.NOVEMBER, 17, 17, 53, 7))
                .balance(new BigDecimal(1700000))
                .build();
    }

    @Test
    public void createAccountTest() throws Exception {
        // given
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        String json = mapper.writeValueAsString(creationDto1);
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/server/account/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON);
        // when
        mockMvc.perform(builder)
                .andDo(print())
                // then
                .andExpect(status().isCreated());
    }

    @Test
    public void findAllTest() throws Exception {
        // given
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        String json1 = mapper.writeValueAsString(creationDto1);
        String json2 = mapper.writeValueAsString(creationDto2);
        String json3 = mapper.writeValueAsString(creationDto3);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/server/account/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json1)
                        .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(builder)
                .andExpect(status().isCreated())
                .andDo(print());

        builder = MockMvcRequestBuilders.post("/server/account/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json2)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(builder)
                // then
                .andExpect(status().isCreated())
                .andDo(print());

        builder = MockMvcRequestBuilders.post("/server/account/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json3)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(builder)
                // then
                .andExpect(status().isCreated())
                .andDo(print());

        builder = MockMvcRequestBuilders.get("/server/account/all");
        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("92114000004170191394451790")))
                .andExpect(content()
                        .string(containsString("88188000098916155367111982")))
                .andExpect(content()
                        .string(containsString("78188000094662356817820269")))
                .andDo(print());
    }
}