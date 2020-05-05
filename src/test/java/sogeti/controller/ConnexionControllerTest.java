package sogeti.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sogeti.model.service.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest
@RunWith(SpringRunner.class)
class ConnexionControllerTest {

    private ConnexionController connexion;

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        userService = new UserService();
        connexion = new ConnexionController();
    }

    @Test
    public void testShowConnexionForm() throws Exception {
        mockMvc.perform(get("/connect"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("index"))
                .andExpect(model().size(1));
    }

    @Test
    public void testSubmitConnexionForm() throws Exception {
        mockMvc.perform(post("/connect"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/homepage"));
    }
}