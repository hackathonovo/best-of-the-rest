package hr.in2.hackathon.projectbackend;

import hr.in2.hackathon.projectbackend.config.CustomWebMvcConfig;
import hr.in2.hackathon.projectbackend.controllers.UsersController;
import hr.in2.hackathon.projectbackend.models.User;
import hr.in2.hackathon.projectbackend.repositories.ActionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ActionRepository.class, UsersController.class, CustomWebMvcConfig.class})
@EntityScan(basePackageClasses = {User.class})
@EnableTransactionManagement
@EnableJpaRepositories
public class ProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectBackendApplication.class, args);
	}
}
