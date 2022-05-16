package io.spring.demo.issuedashboard.project;

import javax.validation.constraints.NotBlank;

public class ProjectData {

    @NotBlank
    private String repoName;

    @NotBlank
    private String orgName;

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
