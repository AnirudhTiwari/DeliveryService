package com.example.DeliveryService;

import com.example.DeliveryService.dao.DeliveryAgentRepository;
import com.example.DeliveryService.model.DeliveryAgent;
import com.example.DeliveryService.model.DeliveryAgentStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DeliveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeDatabase(DeliveryAgentRepository deliveryAgentRepository) {
		return (args) -> {
			// Initialize a few delivery agents
			deliveryAgentRepository.save(DeliveryAgent.builder().name("Akash").status(DeliveryAgentStatus.INACTIVE).build());
			deliveryAgentRepository.save(DeliveryAgent.builder().name("Bharat").status(DeliveryAgentStatus.INACTIVE).build());
			deliveryAgentRepository.save(DeliveryAgent.builder().name("Chandan").status(DeliveryAgentStatus.INACTIVE).build());
		};
	}
}
