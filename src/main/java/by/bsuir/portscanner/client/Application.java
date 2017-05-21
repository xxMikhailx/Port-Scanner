package by.bsuir.portscanner.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ApplicationRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            ScannedHost scannedHost = restTemplate.getForObject(
                    UriComponentsBuilder.newInstance()
                            .scheme("http")
                            .host("localhost:8080")
                            .path("/scan")
                            .queryParam("host", "84.201.234.241")
                            .queryParam("minPort", "80")
                            .queryParam("maxPort", "100")
                            .queryParam("timeout", "50")
                            .build()
                            .toUriString(),
                    ScannedHost.class);
            log.info(scannedHost.toString());
        };
    }
}