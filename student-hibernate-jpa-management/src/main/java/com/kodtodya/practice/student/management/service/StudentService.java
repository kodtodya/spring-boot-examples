package com.kodtodya.practice.student.management.service;

import com.kodtodya.practice.student.management.domain.StudentDomain;
import com.kodtodya.practice.student.management.exception.StudentNotFoundException;
import com.kodtodya.practice.student.management.model.Student;
import com.kodtodya.practice.student.management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        System.out.println("Inside service: " + student);
        StudentDomain domain = this.populateDomain(student);
        return this.populateModel(studentRepository.save(domain));
    }

    public Student deleteStudent(int id) {
        Optional<StudentDomain> domain = studentRepository.findById(id);
        if (!domain.isEmpty()) {
            studentRepository.deleteById(id);
            System.out.println("Deleted student: " + domain.get());
        } else {
            throw new StudentNotFoundException("Student not found");
        }
        return this.populateModel(domain.get());
    }

    public Student retrieveStudent(int id) {
        Optional<StudentDomain> retrievedStudent = studentRepository.findById(id);
        if (retrievedStudent.isEmpty()) {
            throw new StudentNotFoundException("student not found");
        }
        System.out.println("retrievedStudent : " + retrievedStudent);
        return this.populateModel(retrievedStudent.get());
    }

    public List<Student> retrieveStudentByPercentage(double percentage) {
        List<StudentDomain> studentDomains = studentRepository.findByCriteria(percentage);
        return studentDomains.stream()
                .map(this::populateModel).toList();
    }

    public List<Student> retrieveStudents() {
        return studentRepository.findAll().stream()
                .map(this::populateModel).toList();
    }

    protected Student populateModel(StudentDomain domain) {
        return Student.builder()
                .id(domain.getId())
                .name(domain.getName())
                .percentage(domain.getPercentage())
                .build();
    }

    protected StudentDomain populateDomain(Student model) {
        return StudentDomain.builder()
                .id(model.getId())
                .name(model.getName())
                .percentage(model.getPercentage())
                .build();
    }
}
