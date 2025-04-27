package com.kodtodya.practice.student.management.service;

import com.kodtodya.practice.student.management.model.Student;
import com.kodtodya.practice.student.management.model.StudentUpdate;
import com.kodtodya.practice.student.management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student createStudent(Student student) {
        System.out.println("Inside service: " + student);
        return repository.createStudent(student);
    }

    public Student deleteStudent(int id) {
        Student deletedStudent = repository.deleteStudent(id);
        System.out.println("Deleted student: " + deletedStudent);
        return deletedStudent;
    }

    public Student retrieveStudent(int id) {
        Student retrievedStudent = repository.retrieveStudent(id);
        System.out.println("retrievedStudent : " + retrievedStudent);
        return retrievedStudent;
    }

    public Student updatePartialStudent(int id, StudentUpdate student) {
        return repository.updatePartialStudent(id, student);
    }

    public Student updateFullStudent(int id, StudentUpdate student) {
        return repository.updateFullStudent(id, student);
    }

    public Map<Integer, Student> retrieveStudents() {
        return repository.retrieveStudents();
    }

    public List<Student> retrieveStudent(String name) {
        return repository.retrieveStudent(name);
    }
}
