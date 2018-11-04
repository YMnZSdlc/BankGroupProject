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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.sda.bankcommons.domain.dtos.AccountCategoryCreationDto;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountCategoryControllerTest {

    @Autowired
    WebApplicationContext context;

    @Autowired
    private ObjectMapper mapper;

    private AccountCategoryCreationDto creationDto1;
    private AccountCategoryCreationDto creationDto2;
    private AccountCategoryCreationDto creationDto3;

    @Before
    public void setup1() {
        creationDto1 = new AccountCategoryCreationDto(1, "Basic", null);
        creationDto2 = new AccountCategoryCreationDto(2, "Standard", null);
        creationDto3 = new AccountCategoryCreationDto(3, "Exclusive", null);
    }

    @Test
    public void createAccountCategoryTest() throws Exception {
        String json = mapper.writeValueAsString(creationDto1);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void findAllTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        mockMvc.perform(get("/server/accountcategory/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findAccountCategoryTestShouldReturnGivenCategory() throws Exception {
        // given
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        String json1 = mapper.writeValueAsString(creationDto1);
        String json2 = mapper.writeValueAsString(creationDto2);
        String json3 = mapper.writeValueAsString(creationDto3);
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json1)
                .accept(MediaType.APPLICATION_JSON));

        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json2)
                .accept(MediaType.APPLICATION_JSON));

        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json3)
                .accept(MediaType.APPLICATION_JSON));

        String searchedCategory = "Exclusive";
        String expectedResult = "Exclusive";

        // when
        mockMvc.perform(get("/server/accountcategory/find")
                .param("categoryName", searchedCategory))
                .andDo(print())
                // then
                .andExpect(content()
                        .string(containsString(expectedResult)));
    }

    @Test
    public void findAccountCategoryTestShouldNotReturnGivenCategory() throws Exception {
        // given
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        String json1 = mapper.writeValueAsString(creationDto1);
        String json2 = mapper.writeValueAsString(creationDto2);
        String json3 = mapper.writeValueAsString(creationDto3);
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json1)
                .accept(MediaType.APPLICATION_JSON));
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json2)
                .accept(MediaType.APPLICATION_JSON));
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json3)
                .accept(MediaType.APPLICATION_JSON));

        String searchedCategory = "Badass category";
        String expectedResult = "[]";

        // when
        mockMvc.perform(get("/server/accountcategory/find")
                .param("categoryName", searchedCategory))
                .andDo(print())
                // then
                .andExpect(content()
                        .string(containsString(expectedResult)));
    }


    private String oldCategoryName = "Exclusive";
    private String newCategoryName = "Extended";
    private AccountCategoryCreationDto updateDto4;

    @Before
    public void setup2() {
        updateDto4 = new AccountCategoryCreationDto(4, newCategoryName, null);
    }

    @Test
    public void updateAccountCategoryTest() throws Exception {
        // given
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        String json1 = mapper.writeValueAsString(creationDto1);
        String json2 = mapper.writeValueAsString(creationDto2);
        String json3 = mapper.writeValueAsString(creationDto3);
        String json4 = mapper.writeValueAsString(updateDto4);
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json1)
                .accept(MediaType.APPLICATION_JSON));
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json2)
                .accept(MediaType.APPLICATION_JSON));
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json3)
                .accept(MediaType.APPLICATION_JSON));

        // when
        //a different approach using a builder to build request
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.put("/server/accountcategory/update")
                        .param("categoryName",oldCategoryName)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json4);
        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andDo(print());

        // then
        mockMvc.perform(get("/server/accountcategory/find")
                .param("categoryName", newCategoryName))
                .andDo(print())
                // then
                .andExpect(content()
                        .string(containsString(newCategoryName)));
    }

    private String insertedAndDeletedCategoryName = "Inserted And Deleted category";
    private AccountCategoryCreationDto insertedAndDeletedDto;

    @Before
    public void setup3() {
        insertedAndDeletedDto = new AccountCategoryCreationDto(5, insertedAndDeletedCategoryName, null);
    }

    @Test
    public void deleteAccountCategoryTest() throws Exception {
        // given
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        String json1 = mapper.writeValueAsString(creationDto1);
        String json2 = mapper.writeValueAsString(creationDto2);
        String json3 = mapper.writeValueAsString(creationDto3);
        String json4 = mapper.writeValueAsString(insertedAndDeletedDto);
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json1)
                .accept(MediaType.APPLICATION_JSON));
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json2)
                .accept(MediaType.APPLICATION_JSON));
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json3)
                .accept(MediaType.APPLICATION_JSON));
        mockMvc.perform(post("/server/accountcategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json4)
                .accept(MediaType.APPLICATION_JSON));
        //when
        String searchedCategory = insertedAndDeletedCategoryName;
        mockMvc.perform(get("/server/accountcategory/find")
                .param("categoryName", searchedCategory))
                .andDo(print())
                // then
                .andExpect(content()
                        .string(containsString(insertedAndDeletedCategoryName)));
        //then
        mockMvc.perform(delete("/server/accountcategory/delete")
                .param("categoryName", insertedAndDeletedCategoryName))
                .andDo(print())
                .andExpect(status().isOk());

        searchedCategory = insertedAndDeletedCategoryName;
        String expectedResult = "[]";

        mockMvc.perform(get("/server/accountcategory/find")
                .param("categoryName", searchedCategory))
                .andDo(print())
                // then
                .andExpect(content()
                        .string(containsString(expectedResult)));
    }
}