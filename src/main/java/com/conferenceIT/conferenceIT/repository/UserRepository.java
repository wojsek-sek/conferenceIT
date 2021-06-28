package com.conferenceIT.conferenceIT.repository;

import com.conferenceIT.conferenceIT.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<Users,Long> {
    void deleteUsersById(Long id);

    Optional<Users> findUsersById(Long id);

    Optional<Users> findByEmail(String email);
}
