package org.helb.baseproject;

import org.helb.baseproject.model.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class BaseProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseProjectApplication.class, args);
	}

	@GetMapping
	public List<User> myUsers (){
		return List.of(
				new User(
						1L,
						"Moumou",
						"Batmou",
						"DiamondBlack",
						"mail@hotmail.com",
						"TestPass"
				)
		);
	}
}
