package com.nc.airport.backend.repository;

import com.nc.airport.backend.model.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UsersRepository extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query(value = "SELECT * FROM USERS INNER JOIN AUTHORITY ON USERS.AUTHORITY_ID = AUTHORITY.ID ORDER BY USERS.OBJECT_ID", nativeQuery = true)
    List<User> getAll();

    Page<User> findAll(Specification<User> spec, Pageable pageable);

    User findUserByEmail(String email);

    User findUserByEmailAndPassword(String email, String password);

    List<User> findAllByOrderByFirstnameAsc();

    List<User> findAllByOrderByFirstnameDesc();

    List<User> findAllByOrderByLastnameAsc();

    List<User> findAllByOrderByLastnameDesc();

    List<User> findAllByOrderByEmailAsc();

    List<User> findAllByOrderByEmailDesc();

    List<User> findAllByOrderByPhonenumberAsc();

    List<User> findAllByOrderByPhonenumberDesc();
}
