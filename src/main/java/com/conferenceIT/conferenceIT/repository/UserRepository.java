package com.conferenceIT.conferenceIT.repository;

import com.conferenceIT.conferenceIT.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
}
