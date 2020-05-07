package sogeti.controller;

import org.junit.Test;

import javax.mail.MessagingException;
import java.io.IOException;

public class PasswordControllerTest {

    @Test
    public void testMail() throws IOException, MessagingException {
        PasswordController pswd = new PasswordController();
        pswd.sendSecurityCodeEmail("blabla","hcare67000@gmail.com");
    }

}