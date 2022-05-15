create table GITHUB_PROJECT(
id       IDENTITY NOT NULL PRIMARY KEY,
org_name VARCHAR(50) NOT NULL,
repo_name VARCHAR(50) NOT NULL UNIQUE
);

create index idx_repo_name
on github_project(repo_name);