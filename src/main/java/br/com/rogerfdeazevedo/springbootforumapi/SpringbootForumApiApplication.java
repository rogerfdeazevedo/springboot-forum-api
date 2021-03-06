package br.com.rogerfdeazevedo.springbootforumapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class SpringbootForumApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootForumApiApplication.class, args);
	}

}
