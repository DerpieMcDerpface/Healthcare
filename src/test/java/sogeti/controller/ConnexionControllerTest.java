package sogeti.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import sogeti.model.service.UserService;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ConnexionControllerTest {

    private ConnexionController connexionController;

    @MockBean
    UserService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    Model model;

    @Before
    public void setUp(){
        UserService service = Mockito.mock(UserService.class);
        given(service.findUserByUsername("testuser").getPassword()).willReturn("password");
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        // Mockito.when(userService.findUserByUsername("testuser").getPassword()).thenReturn("password");
    }


    @Test
    public void testShowConnexionForm() throws Exception {
        mockMvc.perform(get("/connect"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("index.html"))
                .andExpect(model().size(0));
    }

    @Test
    public void testSubmitOkConnexionForm() throws Exception {
        mockMvc.perform(post("/connect")
                .param("username","testuser").param("password","password"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/homepage.html"));
    }

    @Test
    public void testSubmitNonOkConnexionForm() throws Exception {
        mockMvc.perform(post("/connect")
                .param("username","testuser").param("password","wrong-password"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index.html"));
    }

    @Test
    public void testFunctionConnect(){
        connexionController.connect("testuser","password",model);

    }
}