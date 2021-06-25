package com.conferenceIT.conferenceIT.repository;

import com.conferenceIT.conferenceIT.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    void deleteUsersById(Long id);

    Optional<Users> findUsersById(Long id);
}
