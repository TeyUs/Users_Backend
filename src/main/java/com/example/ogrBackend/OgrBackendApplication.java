package com.example.ogrBackend;

import com.example.ogrBackend.dto.UserCreateDTO;
import com.example.ogrBackend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class OgrBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(OgrBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialUsers(UserService userService){
		return args -> {
			UserCreateDTO user = new UserCreateDTO();
			user.setUserName("teytey");
			user.setFirstName("Teyhan");
			user.setLastName("Uslu");
			userService.createUser(user);

			UserCreateDTO user2 = new UserCreateDTO();
			user2.setUserName("teydur");
			user2.setFirstName("Büşra");
			user2.setLastName("Uslu");
			userService.createUser(user2);


			UserCreateDTO user3 = new UserCreateDTO();
			user3.setUserName("alpuwi");
			user3.setFirstName("Alperen");
			user3.setLastName("koca");
			userService.createUser(user3);
		};
	}
}
