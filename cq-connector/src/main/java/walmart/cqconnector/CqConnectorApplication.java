package walmart.cqconnector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CqConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqConnectorApplication.class, args);
	}

}
