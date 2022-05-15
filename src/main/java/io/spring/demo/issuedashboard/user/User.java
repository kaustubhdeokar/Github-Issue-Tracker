package io.spring.demo.issuedashboard.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String organisation;

    public User(){}

    public User(String name, String organisation) {
        this.name = name;
        this.organisation = organisation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrganisation() {
        return organisation;
    }
}
