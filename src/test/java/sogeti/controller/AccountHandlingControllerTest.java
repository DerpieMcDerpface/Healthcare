package sogeti.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest
class AccountHandlingControllerTest {

    AccountHandlingController accountHandlingController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowCreateAccountPage() throws Exception{
        mockMvc.perform(get("/createaccount.html"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("create"))
                .andExpect(model().size(1));
    }

    @Test
    public void testSaveUser() throws Exception {
        mockMvc.perform(post("/createaccount.html"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/homepage.html"));
    }

}