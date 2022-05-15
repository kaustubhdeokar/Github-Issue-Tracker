package io.spring.demo.issuedashboard.events;

import io.spring.demo.issuedashboard.github.RepositoryEvent;
import io.spring.demo.issuedashboard.project.GithubProject;

import java.util.List;

public class DashboardEntry {

    private final GithubProject project;
    private final List<RepositoryEvent> events;

    public DashboardEntry(GithubProject project, List<RepositoryEvent> events) {
        this.project = project;
        this.events = events;
    }

    public GithubProject getProject() {
        return project;
    }

    public List<RepositoryEvent> getEvents() {
        return events;
    }
}