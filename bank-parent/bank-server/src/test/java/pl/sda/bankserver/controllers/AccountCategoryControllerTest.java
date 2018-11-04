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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.sda.bankcommons.domain.dtos.AccountCategoryCreationDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountCategoryControllerTest {

    @Autowired
    WebApplicationContext context;

    @Autowired
    private ObjectMapper mapper;

    private AccountCategoryCreationDto creationDto;

    @Before
    public void setup() {
        creationDto = new AccountCategoryCreationDto(1, "Nowy typ konta", null);
    }

    @Test
    public void shouldReturnCreatedStatus() throws Exception {
        String json = mapper.writeValueAsString(creationDto);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isCreated());
    }
}