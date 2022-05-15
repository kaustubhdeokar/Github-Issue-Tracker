package io.spring.demo.issuedashboard.organisation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Organisation {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Organisation() {
    }

    public Organisation(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
