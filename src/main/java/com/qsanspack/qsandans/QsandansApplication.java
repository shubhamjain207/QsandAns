package com.qsanspack.qsandans;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.qsanspack.qsandans.entities.Question;
import com.qsanspack.qsandans.entities.Role;
import com.qsanspack.qsandans.entities.User;
import com.qsanspack.qsandans.repos.UserRepo;

@SpringBootApplication
@CrossOrigin
public class QsandansApplication {

	public static void main(String[] args) {
		SpringApplication.run(QsandansApplication.class, args);
	}
	@Bean
	CommandLineRunner run(UserRepo userRepo,PasswordEncoder encoder){

		
		return args->{

			if(userRepo.findByUsername("admin").isPresent()) return;

			
				Set<Role> roles = new HashSet<>();
				

				roles.add(new Role("ADMIN"));
				

				User admin = new User(0,"admin",encoder.encode("password"),"","Admin",roles);

				userRepo.save(admin);
		};
	}

}
