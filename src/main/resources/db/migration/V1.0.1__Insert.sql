INSERT INTO GITHUB_PROJECT(ORG_NAME,REPO_NAME) values ('spring-projects', 'spring-boot');
INSERT INTO GITHUB_PROJECT(ORG_NAME,REPO_NAME) values ('spring-io', 'initializr');
INSERT INTO GITHUB_PROJECT(ORG_NAME,REPO_NAME) values ('spring-io', 'sagan');

create table USER(
id      IDENTITY NOT NULL PRIMARY KEY,
name    VARCHAR(50) NOT NULL,
org_name VARCHAR(50) NOT NULL
);

INSERT INTO USER(NAME,ORG_NAME) values ('user1','spring-projects');
INSERT INTO USER(NAME,ORG_NAME) values ('user2','spring-io');

create table ORGANISATION(
id IDENTITY NOT NULL PRIMARY KEY,
name VARCHAR(50) NOT NULL
);

INSERT INTO ORGANISATION(NAME) values ('spring-projects');
INSERT INTO ORGANISATION(NAME) values ('spring-io');
