package ssg.com.a;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 접속허가
@Configuration
public class WebConfigurer implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		// 원래는 *으로 모든부분으로 허용하면 안됨 서버지정해야함
		// registry.addMapping("/**").allowedOrigins("http//localhost:9000");
		registry.addMapping("/**").allowedOrigins("*");
	}
	
}
