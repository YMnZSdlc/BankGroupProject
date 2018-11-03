package pl.sda.bankclient.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DepartmentsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnOkStatus() throws Exception{
        this.mockMvc.perform(get("/departments/save")).andDo(print()).andExpect(status().isOk());
    }

}
