package sogeti.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import sogeti.model.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterProtocol {

    @GetMapping("/register")
    public ModelAndView getRegisterForm() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("User", new User());
        return new ModelAndView("register", model);
    }
    @PostMapping("/register")
    public ModelAndView submitRegistration(User user) {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO user(Id, Surname, Name, Mail, Password, isDoctor) VALUES (");
        query.append("'").append(user.getId()).append("',");
        query.append("'").append(user.getName()).append("',");
        query.append("'").append(user.getSurname()).append("',");
        query.append("'").append(user.getMail()).append("',");
        query.append("'").append(user.getPassword()).append("',");
        query.append("'1');");
        //sb.append("'").append(user.isDoctor()).append("');");



        try {
            Connection con = DatabaseConnection.connectDB();
            PreparedStatement preparedStatement = con.prepareStatement(query.toString());
            preparedStatement.execute();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");
        return new ModelAndView(redirectView);
    }

}
