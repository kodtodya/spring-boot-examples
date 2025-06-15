package com.kodtodya.practice.student.management.controller;

import com.kodtodya.practice.student.management.model.Student;
import com.kodtodya.practice.student.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/studentManagement")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("Inside controller: " + student);
        return new ResponseEntity(service.createStudent(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> createStudent(@PathVariable("id") int studentId) {
        System.out.println("Inside controller: " + studentId);
        return new ResponseEntity(service.deleteStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> retrieveStudent(@PathVariable("id") int studentId) {
        System.out.println("Inside controller: " + studentId);
        return new ResponseEntity(service.retrieveStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("/students")
    public List<Student> retrieveStudent() {
        return service.retrieveStudents();
    }

    @GetMapping("/students/map")
    public ResponseEntity<Map<Integer, Student>> retrieveStudentMap() {
        return new ResponseEntity(service.retrieveStudentsMap(), HttpStatus.OK);
    }

    @GetMapping("/students/page/{page}/size/{size}")
    public ResponseEntity<List<Student>> retrieveStudent(
            @PathVariable("page") int page,
            @PathVariable("size") int size) {
        System.out.println(page + "|" + size);
        return new ResponseEntity<>(service.findStudentWithPagination(page, size), HttpStatus.OK);
    }
}
