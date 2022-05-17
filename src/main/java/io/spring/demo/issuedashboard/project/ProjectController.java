package io.spring.demo.issuedashboard.project;

import io.spring.demo.issuedashboard.events.DashboardEntry;
import io.spring.demo.issuedashboard.github.GithubClient;
import io.spring.demo.issuedashboard.github.RepositoryEvent;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class ProjectController {

    private final GithubProjectRepository repository;
    private final GithubClient githubClient;
    private final ProjectService service;

    public ProjectController(GithubProjectRepository repository, GithubClient githubClient, ProjectService service) {
        this.repository = repository;
        this.githubClient = githubClient;
        this.service = service;
    }

    @GetMapping("/project/{repoName}")
    @ResponseBody
    public RepositoryEvent[] fetchEvents(@PathVariable String repoName) {
        GithubProject project = repository.findByRepoName(repoName);
        return this.githubClient.fetchEvents(project.getOrgName(), project.getRepoName()).getBody();
    }


    @GetMapping("/admin")
    public String adminPage(Model model){
        model.addAttribute("projects",this.repository.findAll());
        return "admin";
    }

    @GetMapping("/project/add/{name}")
    @Secured("ROLE_ADMIN")
    public String addProject(@PathVariable("name") String name, Model model) {
        System.out.println("Inside project add.");
        //organisation name - name,
        model.addAttribute("orgName",name);
        model.addAttribute("github_project",new ProjectData());
        //form project name -> user will add.
        return "projectadd";
    }

    @PostMapping("/project/create")
    public String createProject(@ModelAttribute("github_project") ProjectData githubProject,
                                BindingResult bindingResult, Model model){
        System.out.println("Here in project post");
        String repoName = githubProject.getRepoName();
        String orgName = githubProject.getOrgName();
        service.addProject(orgName,repoName);
        return "redirect:/organisation";
    }


    @GetMapping("/")
    public String dashboard(Model model){

        Iterable<GithubProject> projects = this.repository.findAll();
        List<DashboardEntry> entries = StreamSupport.stream(projects.spliterator(), true).
                map(p -> new DashboardEntry(p, this.githubClient.fetchEventsAsList(p.getOrgName(), p.getRepoName()))).
                collect(Collectors.toList());
        model.addAttribute("entries",entries);

        return "dashboard";
    }
}
