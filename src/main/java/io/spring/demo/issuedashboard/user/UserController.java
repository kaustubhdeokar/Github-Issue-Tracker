package io.spring.demo.issuedashboard.user;

import io.spring.demo.issuedashboard.project.GithubProjectRepository;
import io.spring.demo.issuedashboard.github.GithubClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private final GithubProjectRepository repository;
    private final GithubClient githubClient;
    final UserService userService;

    public UserController(GithubProjectRepository repository, GithubClient githubClient, UserService service) {
        this.repository = repository;
        this.githubClient = githubClient;
        this.userService = service;
    }

    @GetMapping("/users/{id}")
    public void showUserProjects(@PathVariable String id, Model model){

        User user = userService.getUser(Long.parseLong(id));
        String organisation = user.getOrganisation();

    }

}
