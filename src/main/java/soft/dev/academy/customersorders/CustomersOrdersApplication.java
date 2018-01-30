package soft.dev.academy.customersorders;

import org.omg.CORBA.Environment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CustomersOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersOrdersApplication.class, args);
	}

}
