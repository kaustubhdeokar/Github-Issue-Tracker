package io.spring.demo.issuedashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.info.GitProperties;

@SpringBootApplication
@EnableConfigurationProperties(GithubProperties.class)
public class IssueDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(IssueDashboardApplication.class, args);
    }

}
