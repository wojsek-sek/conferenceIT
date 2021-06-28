package com.conferenceIT.conferenceIT.controller;


import com.conferenceIT.conferenceIT.model.Lectures;
import com.conferenceIT.conferenceIT.service.LecturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectures")
@RequiredArgsConstructor
public class LecturesController {

    private final LecturesService lecturesService;


    @GetMapping("/all")
    public ResponseEntity<List<Lectures>> getAllLectures() {
        List<Lectures> lectures = lecturesService.findAllUsers();
        return new ResponseEntity<>(lectures, HttpStatus.OK);

    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Lectures> getLecturesById(@PathVariable("id") Long id ) {
        Lectures lectures= lecturesService.findUsersById(id);
        return new ResponseEntity<>(lectures, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Lectures> addLectures(@RequestBody Lectures lectures) {
        Lectures newLectures = lecturesService.addLectures(lectures);
        return new ResponseEntity<>(newLectures, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Lectures> updateLectures(@RequestBody Lectures lectures) {
        Lectures updateLectures = lecturesService.updateLectures(lectures);
        return new ResponseEntity<>(updateLectures, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLectures(@PathVariable("id") Long id) {
        lecturesService.deleteLectures(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
