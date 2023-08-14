package my.project.mininetservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MiniHostelApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MiniHostelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}