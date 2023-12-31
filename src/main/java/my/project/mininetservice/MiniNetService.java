package my.project.mininetservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MiniNetService implements CommandLineRunner {

	@Value("${security.jwt.expiration-minutes}")
    private static long EXPIRATION_MINUTES;

	public static void main(String[] args) {
		SpringApplication.run(MiniNetService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

	/*@Bean
	public CommandLineRunner createPasswordCommand () {
		return args -> {
			System.out.println(passwordEncoder.encode("123"));
		};
	}*/
}
