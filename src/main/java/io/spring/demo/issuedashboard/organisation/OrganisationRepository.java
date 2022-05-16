package io.spring.demo.issuedashboard.organisation;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrganisationRepository extends PagingAndSortingRepository<Organisation, OrganisationId> {
}
