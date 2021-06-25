package com.conferenceIT.conferenceIT.service;



import com.conferenceIT.conferenceIT.exception.LecturesNotFoundException;
import com.conferenceIT.conferenceIT.model.Lectures;
import com.conferenceIT.conferenceIT.repository.LecturesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LecturesService {

    private final LecturesRepository lecturesRepository;


    public Lectures addLectures(Lectures lectures) {
        lectures.setLecturesCode(UUID.randomUUID().toString());
        return lecturesRepository.save(lectures);
    }

    public Lectures updateLectures(Lectures lectures){
        return lecturesRepository.save(lectures);
    }

    public void deleteLectures(Long id ){
        lecturesRepository.deleteLecturesById(id);
    }

    public List<Lectures> findAllUsers() {
        return lecturesRepository.findAll();
    }

    public Lectures findUsersById(Long id) {
        return lecturesRepository.findLecturesById(id).orElseThrow(()->new LecturesNotFoundException("User not found"));

    }
}
