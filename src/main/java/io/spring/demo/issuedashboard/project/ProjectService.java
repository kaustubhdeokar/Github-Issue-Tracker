package io.spring.demo.issuedashboard.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectService {


    @Autowired
    GithubProjectRepository repository;

    public void addProject(String orgName, String repoName){
        GithubProject project = new GithubProject(orgName,repoName);
        repository.save(project);
    }

}
