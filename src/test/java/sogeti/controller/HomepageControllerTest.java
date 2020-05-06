package sogeti.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@RunWith(SpringRunner.class)
class HomepageControllerTest {

    private HomepageController homepage;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        homepage = new HomepageController();
    }

    @Test
    public void testShowHomepage() throws Exception {
        mockMvc.perform(get("/homepage"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("homepage"));
    }

}