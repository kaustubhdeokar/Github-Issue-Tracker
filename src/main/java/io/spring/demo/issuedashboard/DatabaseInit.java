package io.spring.demo.issuedashboard;

import io.spring.demo.issuedashboard.organisation.OrganisationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("init-db")
public class DatabaseInit implements CommandLineRunner {

    final OrganisationService organisationService;

    public DatabaseInit(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @Override
    public void run(String... args) throws Exception {

        organisationService.createOrganisation("spring-projects");
        organisationService.createOrganisation("spring-io");

    }
}
