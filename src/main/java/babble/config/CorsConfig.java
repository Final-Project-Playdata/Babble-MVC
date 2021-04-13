package babble.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

	@Bean
   public CorsFilter corsFilter() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      List<String> originList = new ArrayList<String>();
      originList.add("*");
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);
      config.setAllowedOriginPatterns(originList);
      config.addAllowedHeader("*");
      config.addAllowedMethod("*");
      config.setExposedHeaders(originList);

      source.registerCorsConfiguration("/**", config);
      return new CorsFilter(source);
   }

}
