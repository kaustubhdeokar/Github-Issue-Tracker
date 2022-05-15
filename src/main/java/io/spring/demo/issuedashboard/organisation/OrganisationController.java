package io.spring.demo.issuedashboard.organisation;

import io.spring.demo.issuedashboard.events.DashboardEntry;
import io.spring.demo.issuedashboard.github.GithubClient;
import io.spring.demo.issuedashboard.project.GithubProject;
import io.spring.demo.issuedashboard.project.GithubProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class OrganisationController {

    final OrganisationService organisationService;
    final GithubProjectRepository projectRepository;
    private final GithubClient githubClient;

    public OrganisationController(OrganisationService service, GithubProjectRepository projectRepository, GithubClient githubClient) {
        this.organisationService = service;
        this.projectRepository = projectRepository;
        this.githubClient = githubClient;
    }

    @GetMapping("/organisation")
    public String getAllOrganisation(Model model) {
        Iterable<Organisation> allOrganisations = organisationService.getAllOrganisations();
        model.addAttribute("organisations", allOrganisations);
        return "organisation";
    }

    @GetMapping("/organisation/{id}")
    public String getAllOrganisationById(@PathVariable("id") String organisationId, Model model) {
        Organisation organisationById = organisationService.getOrganisationById(Long.parseLong(organisationId));
        model.addAttribute("organisations",organisationById);

        Iterable<GithubProject> projects = this.projectRepository.findAll();

        List<DashboardEntry> entries = StreamSupport.stream(projects.spliterator(), true).
                filter(project->project.getOrgName().equals(organisationById.getName())).
                map(p -> new DashboardEntry(p, this.githubClient.fetchEventsAsList(p.getOrgName(), p.getRepoName()))).
                collect(Collectors.toList());

        model.addAttribute("entries",entries);

        return "organisation";
    }
}