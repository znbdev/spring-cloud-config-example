package example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
// This will allow us to reinitialize this controller to get any new config
// values when the /refresh endpoint is POSTed to.
@RefreshScope
public class ClientController {

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${spring.profiles}")
    private String profiles;
    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @RequestMapping("/config")
    public String cloudConfig() {
        String configStr = profiles + "-" + applicationName + ":" + serverPort;
        log.info(configStr);

        log.info("Url: {}", url);
        log.info("Username: {}", username);
        log.info("Password: {}", password);

        return "Using [" + configStr + "] from config server";
    }

    @RequestMapping("/")
    public String index() {
        String envUrl = "http://127.0.0.1:" + serverPort + "/env";
        return "<p>env confirm : <a href=" + envUrl + " target='_blank' rel='noopener noreferrer'>env</a>.</p>";
    }
}
