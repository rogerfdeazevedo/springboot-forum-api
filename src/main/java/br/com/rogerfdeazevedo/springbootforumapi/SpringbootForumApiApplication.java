package br.com.rogerfdeazevedo.springbootforumapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableWebMvc
@EnableSwagger2
public class SpringbootForumApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootForumApiApplication.class, args);
	}

}
