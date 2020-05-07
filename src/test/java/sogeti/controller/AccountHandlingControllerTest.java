package sogeti.controller;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;
import sogeti.model.User;
import sogeti.model.service.NewsService;
import sogeti.model.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AccountHandlingControllerTest {

    AccountHandlingController accountHandlingController;

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService service;
    @MockBean
    private NewsService newsService;

    private User userWayne;

    @Before
    public void init(){
        userWayne = new User("Wayne","Bruce","WayneB","bru@gmail.com","123");
        when(service.findUserByUsername("WayneB")).thenReturn(userWayne);
    }

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
                .andExpect(status().isOk())
                .andExpect(view().name("index.html"));
    }

    @Test
    public void testShowProfileErrorPage() throws Exception{
        mockMvc.perform(get("/account/profile"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("404.html"))
                .andExpect(model().size(1));
    }

    @Test
    public void testShowProfilePage() throws Exception{
        User user = new User("billy","bosch","bb","blabla@gmail.com","123");
        when(service.getAuthUser()).thenReturn(user);
        mockMvc.perform(get("/account/profile"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("profile.html"))
                .andExpect(model().size(1));
    }

    @Test
    public void testShowProfileEditPage() throws Exception {
        mockMvc.perform(get("/account/profile/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("editprofile.html"))
                .andExpect(model().size(1));
    }

   /* @Test
    public void testEditUser() throws Exception{
        User user = service.findUserByUsername("WayneB");
        user.setName("bob");
        mockMvc.perform(post("/account/profile/edit")
                .param("user-name","bob"))
                .andExpect(status().isOk())
        .andExpect(jsonPath("$[1].name",is("bob")));

    }*/

}