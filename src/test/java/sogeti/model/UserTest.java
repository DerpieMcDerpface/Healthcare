package sogeti.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest
@RunWith(SpringRunner.class)
public class UserTest {

    User userTest;

    @Before
    public void init() {
        userTest = new User("name", "surname", "username", "email", "password");
    }

    @Test
    public void testName() {
        userTest.setName("Bruce");
        assertEquals("Bruce", userTest.getName());
    }

    @Test
    public void testSurname() {
        userTest.setSurname("Wayne");
        assertEquals("Wayne", userTest.getSurname();
    }

    @Test
    public void testUsername() {
        userTest.setUsername("WayneB");
        assertEquals("WayneB", userTest.getUsername());
    }

    @Test
    public void testEmail() {
        userTest.setEmail("bruce.wayne@gmail.com");
        assertEquals("bruce.wayne@gmail.com", userTest.getEmail());
    }

    @Test
    public void testPassword() {
        userTest.setName("Batman123");
        assertEquals("Batman123", userTest.getPassword());
    }
}
