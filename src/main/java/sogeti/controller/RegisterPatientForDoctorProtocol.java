package sogeti.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import sogeti.model.Patient;
import sogeti.model.User;

@Controller
public class RegisterPatientForDoctorProtocol {
	
	@GetMapping("/DoctorRegisterForPatientForm")
    public ModelAndView getPatientRegisterForm() {
		String viewName = "patientRegisterForm";
		Map<String, Object> model = new HashMap<String, Object>();
        model.put("User", new User());
        return new ModelAndView("DoctorRegisterForPatientForm", model);
    }
	
    @PostMapping("/DoctorRegisterForPatientForm")
    public ModelAndView submitRegistration(Patient patient) {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO patient(id_patient, nom_patient, prenom_patient, age_patient, adresse_patient, cp_patient, ville_patient, mail_patient, telephone_patient, numCV_patient, nom_medtraitant, prenom_medtraitant, telephone_medtraitant, mail_medtraitant, adresse_medtraitant, cp_medtraitant, ville_medtraitant, nom_contacturgence, prenom_contacturgence, telephone_contacturgence, mail_contacturgence) VALUES (");
        query.append("'").append(patient.getId_patient()).append("',");
        query.append("'").append(patient.getNom_patient()).append("',");
        query.append("'").append(patient.getPrenom_patient()).append("',");
        query.append("'").append(patient.getAge_patient()).append("',");
        query.append("'").append(patient.getAdresse_patient()).append("',");
        query.append("'").append(patient.getCp_patient()).append("',");
        query.append("'").append(patient.getVille_patient()).append("',");
        query.append("'").append(patient.getMail_patient()).append("',");
        query.append("'").append(patient.getTelephone_patient()).append("',");
        query.append("'").append(patient.getNumCV_patient()).append("',");
        query.append("'").append(patient.getSante_patient()).append("',");
        query.append("'").append(patient.getNom_medtraitant()).append("',");
        query.append("'").append(patient.getPrenom_medtraitant()).append("',");
        query.append("'").append(patient.getTelephone_medtraitant()).append("',");
        query.append("'").append(patient.getMail_medtraitant()).append("',");
        query.append("'").append(patient.getAdresse_medtraitant()).append("',");
        query.append("'").append(patient.getCp_medtraitant()).append("',");
        query.append("'").append(patient.getVille_medtraitant()).append("',");
        query.append("'").append(patient.getNom_contacturgence()).append("',");
        query.append("'").append(patient.getPrenom_contacturgence()).append("',");
        query.append("'").append(patient.getTelephone_contacturgence()).append("',");
        query.append("'").append(patient.getMail_contacturgence()).append("',");
        
        

        try {
            Connection conPatient = DatabaseConnection.connectDB();
            PreparedStatement preparedStatement = conPatient.prepareStatement(query.toString());
            preparedStatement.execute();
            conPatient.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");
        return new ModelAndView(redirectView);
    }	
}
