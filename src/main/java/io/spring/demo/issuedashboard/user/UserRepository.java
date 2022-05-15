package io.spring.demo.issuedashboard.user;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {

}
