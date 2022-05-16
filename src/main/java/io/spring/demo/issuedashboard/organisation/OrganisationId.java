package io.spring.demo.issuedashboard.organisation;

import io.github.wimdeblauwe.jpearl.AbstractEntityId;

import java.util.UUID;

public class OrganisationId extends AbstractEntityId<UUID> {

    protected OrganisationId() {
    }

    public OrganisationId(UUID id) {
        super(id);
    }
}
