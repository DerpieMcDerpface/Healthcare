package sogeti.controller;

import org.junit.Test;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordControllerTest {

    @Test
    public void testMail() throws IOException, MessagingException {
        PasswordController pswd = new PasswordController();
        pswd.sendmail("blabla","hcare67000@gmail.com");
    }

}