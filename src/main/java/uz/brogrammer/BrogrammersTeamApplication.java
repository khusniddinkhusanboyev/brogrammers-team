package uz.brogrammer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("uz.brogrammer")
public class BrogrammersTeamApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrogrammersTeamApplication.class, args);
	}

}
