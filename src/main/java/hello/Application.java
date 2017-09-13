package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// Save a couple of customers
			reposiory.save(new Customer("John", "Doe"));
			reposiory.save(new Customer("Jane", "Doe"));

			// Fetch all customers
			log.info("Customers found with findAll():")
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// Fetch an individual customer by its ID
			Customer customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info(customer.toString());
			log.info("");

			// Fetch a customer by its last name
			log.info("Customer found with findByLastName('Doe'):");
			for(Customer doe : repository.findByLastName('Doe')) {
				log.info(doe.toString());
			}
			log.info("");
		};
	}
}