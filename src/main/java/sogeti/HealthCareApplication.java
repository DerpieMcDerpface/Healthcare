package sogeti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import sogeti.controller.SendEmail;


@SpringBootApplication
public class HealthCareApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HealthCareApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HealthCareApplication.class, args);
	}

	SendEmail s = new SendEmail("hcare67000@gmail.com", "hcare67000@gmail.com");


}
