package io.spring.demo.issuedashboard.project;

import javax.persistence.*;

@Entity(name="GITHUB_PROJECT")
public class GithubProject{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orgName;

    @Column(unique = true)
    private String repoName;

    public GithubProject(){

    }

    public GithubProject(String orgName, String repoName) {
        this.orgName = orgName;
        this.repoName = repoName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public Long getId() {
        return id;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getRepoName() {
        return repoName;
    }

    @Override
    public String toString() {
        return "GithubProject{" +
                "id=" + id +
                ", orgName='" + orgName + '\'' +
                ", repoName='" + repoName + '\'' +
                '}';
    }
}
