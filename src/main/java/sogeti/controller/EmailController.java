package sogeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sogeti.model.Patient;

import org.springframework.mail.javamail.JavaMailSender;

@Controller
public class EmailController {
 
    @Autowired
    public JavaMailSender emailSender;
 
    @ResponseBody
    @RequestMapping("/DoctorRegisterForPatientForm")
    public String sendInscriptionEmail(Patient patient) {
    	
 
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(patient.getMail_medtraitant());
        message.setSubject("Récapitulatif des données d'insciption");
        message.setText("Bonjour, vous avez bien inscrit Mr/Mme "+patient.getNom_patient()+" "+patient.getPrenom_patient()+"\n"+
        				"Voici le récapitulatif des données que vous avez saisi pour votre patient : \n"+
        		"NOM : "+patient.getNom_patient()+"\n"+
        		"PRENOM : "+patient.getPrenom_patient()+"\n"+
        		"AGE : "+patient.getAge_patient()+"\n"+
        		"ADRESSE : "+patient.getAdresse_patient()+"\n"+
        		"CODE POSTAL : "+patient.getCp_patient()+"\n"+
        		"VILLE : "+patient.getVille_patient()+"\n"+
        		"E-MAIL : "+patient.getMail_patient()+"\n"+
        		"N° TELEPHONE : "+patient.getTelephone_patient()+"\n"+
        		"N° CARTE VITALE : "+patient.getNumCV_patient());
 
        // Send Message!
        this.emailSender.send(message);
 
        return "Email Sent!";
    }
 
}
