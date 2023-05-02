package uz.brogrammer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import uz.brogrammer.securety.model.Role;
import uz.brogrammer.securety.model.User;
import uz.brogrammer.securety.repository.UserRepository;

@SpringBootApplication
@ComponentScan("uz.brogrammer")
public class BrogrammersTeamApplication/* implements CommandLineRunner*/ {
	/*private final UserRepository userRepository;
	public BrogrammersTeamApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(BrogrammersTeamApplication.class, args);
	}



	/*@Override
	public void run(String... args) throws Exception {
		if (userRepository.findAll().isEmpty()) {
			User user = User.builder()
					.email("admin@gmail.com")
					.userName("admin")
					.password("password")
					.role(Role.valueOf("ADMIN"))
					.build();
			userRepository.save(user);
		}
	}*/
}


