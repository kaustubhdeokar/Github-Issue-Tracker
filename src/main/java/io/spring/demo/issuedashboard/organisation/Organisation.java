package io.spring.demo.issuedashboard.organisation;

import io.github.wimdeblauwe.jpearl.AbstractVersionedEntity;

import javax.persistence.Entity;

@Entity(name="ORGANISATION")
public class Organisation extends AbstractVersionedEntity<OrganisationId> {

    private String name;

    protected Organisation() {
    }

    public Organisation(OrganisationId organisationId, String name) {
        super(organisationId);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
