package uz.brogrammer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import uz.brogrammer.registration.model.Course;
import uz.brogrammer.registration.service.CourseService;
import uz.brogrammer.securety.model.Role;
import uz.brogrammer.securety.model.User;
import uz.brogrammer.securety.repository.UserRepository;

@SpringBootApplication
@ComponentScan("uz.brogrammer")
@RequiredArgsConstructor
public class BrogrammersTeamApplication implements CommandLineRunner {
	private final CourseService courseService;
	public static void main(String[] args) {
		SpringApplication.run(BrogrammersTeamApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		courseService.addCourse(Course.builder().id(1).courseTitle("Java Web Backend").days("Monday, Wednesday,Saturday").time("6 pm").build());
	}
}


