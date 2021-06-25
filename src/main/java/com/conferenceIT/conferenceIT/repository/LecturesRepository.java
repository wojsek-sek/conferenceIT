package com.conferenceIT.conferenceIT.repository;

import com.conferenceIT.conferenceIT.model.Lectures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LecturesRepository extends JpaRepository<Lectures,Long> {
    void deleteLecturesById(Long id);

    Optional<Lectures> findLecturesById(Long id);
}
