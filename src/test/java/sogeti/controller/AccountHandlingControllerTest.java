package sogeti.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;
import sogeti.model.service.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AccountHandlingControllerTest {

    AccountHandlingController accountHandlingController;

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService service;

    @Test
    public void testShowCreateAccountPage() throws Exception{
        mockMvc.perform(get("/account/create"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("createaccount.html"))
                .andExpect(model().size(1));
    }

    @Test
    public void testSaveUser() throws Exception {
        mockMvc.perform(post("/account/create"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("homepage.html"));
    }

    @Test
    public void testShowCreateAccountByDoctor() throws Exception{
        mockMvc.perform(get("/account/create"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("createaccount.html"))
                .andExpect(model().size(1));
    }

    @Test
    public void testSaveUserDoctor() throws Exception {
        mockMvc.perform(post("/account/create"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("homepage.html"));
    }

}