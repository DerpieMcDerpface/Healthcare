package sogeti.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTest {

    Role roleTest;

    @Before
    public void init() {
        roleTest = new Role("name");
    }

    @Test
    public void nameTest(){
        roleTest.setName("Billy");
        assertEquals("Billy",roleTest.getName());
    }

}
