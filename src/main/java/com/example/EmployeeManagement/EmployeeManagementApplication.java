package com.example.EmployeeManagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info= @Info(
				title = "Spring Boot User Managment Rest API Documentation",
				description ="Spring Boot User Management",
				version = "v1.0",
				contact = @Contact(
						name="Sabarirajan",
						email = "sabari@gmail.com"
				),
				license = @License(
						name="Apache 2.0",
						url="https://www.usermanagement.in"
				)

		)
)
public class EmployeeManagementApplication {


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
