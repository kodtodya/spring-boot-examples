package com.kodtodya.practice.student.management.controller;

import com.kodtodya.practice.student.management.model.Group;
import com.kodtodya.practice.student.management.model.StudentGroupProjection;
import com.kodtodya.practice.student.management.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groupManagement")
public class GroupController {

    @Autowired
    private GroupService service;

    @PostMapping("/group")
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        System.out.println("Inside controller: " + group);
        return new ResponseEntity(service.createGroup(group), HttpStatus.CREATED);
    }

    @GetMapping("/group-student")
    public ResponseEntity<List<StudentGroupProjection>> fetchStudentGroupById(@RequestParam(name = "id") int id) {
        System.out.println("Inside controller: " + id);
        return new ResponseEntity(service.fetchStudentGroupById(id), HttpStatus.OK);
    }

//    @DeleteMapping("/student/{id}")
//    public ResponseEntity<Student> createStudent(@PathVariable("id") int studentId) {
//        System.out.println("Inside controller: " + studentId);
//        return new ResponseEntity(service.deleteStudent(studentId), HttpStatus.OK);
//    }
//
//    @GetMapping("/student/{id}")
//    public ResponseEntity<Student> retrieveStudent(@PathVariable("id") int studentId) {
//        System.out.println("Inside controller: " + studentId);
//        return new ResponseEntity(service.retrieveStudent(studentId), HttpStatus.OK);
//    }
//
//    @GetMapping("/students")
//    public List<Student> retrieveStudent() {
//        return service.retrieveStudents();
//    }
}
