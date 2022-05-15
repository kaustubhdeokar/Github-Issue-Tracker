package io.spring.demo.issuedashboard.organisation;

import io.spring.demo.issuedashboard.project.GithubProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationService {

    @Autowired
    OrganisationRepository organisationRepository;



    public Iterable<Organisation> getAllOrganisations(){
        return organisationRepository.findAll();
    }

    public Organisation getOrganisationById(long orgId){
        return organisationRepository.findById(orgId).orElseThrow(()->new RuntimeException("Not found"));
    }

}
