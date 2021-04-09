package babble.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilConfig {

	@Bean
	public AudioUtil audioUtil() {
		return new AudioUtil();
	}
}
