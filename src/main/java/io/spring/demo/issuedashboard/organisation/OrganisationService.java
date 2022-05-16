package io.spring.demo.issuedashboard.organisation;

import io.spring.demo.issuedashboard.project.GithubProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganisationService {

    @Autowired
    OrganisationRepository organisationRepository;

    public Iterable<Organisation> getAllOrganisations(){
        return organisationRepository.findAll();
    }

    public Organisation getOrganisationById(OrganisationId orgId){
        return organisationRepository.findById(orgId).orElseThrow(()->new RuntimeException("Not found"));
    }

    public Organisation createOrganisation(String name){

        Organisation organisation = new Organisation(nextId(),name);
        return organisationRepository.save(organisation);
    }

    public OrganisationId nextId(){
        return new OrganisationId(UUID.randomUUID());
    }

}
