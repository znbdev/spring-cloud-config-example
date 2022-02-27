package example;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    /**
     * Output property from cloud-config-server on startup of app,
     *
     * also can be seen at:
     * http://localhost:8080/env/info.foo
     */
    @Bean
    public CommandLineRunner printProperties(@Value("${spring.profiles}") final String env)  {
        return args -> log.info("spring.profiles is: [{}]", env);
    }

}
