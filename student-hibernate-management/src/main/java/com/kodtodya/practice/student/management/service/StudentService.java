package com.kodtodya.practice.student.management.service;

import com.kodtodya.practice.student.management.exception.StudentNotFoundException;
import com.kodtodya.practice.student.management.model.Student;
import com.kodtodya.practice.student.management.repository.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentRepositoryImpl studentRepository;

    public Student createStudent(Student student) {
        System.out.println("Inside service: " + student);
        return studentRepository.save(student);
    }

    public Student deleteStudent(int id) {
        Student deletedStudent = studentRepository.deleteById(id);
        System.out.println("Deleted student: " + deletedStudent);
        return deletedStudent;
    }

    public Student retrieveStudent(int id) {
        Optional<Student> retrievedStudent = studentRepository.findById(id);
        if (retrievedStudent.isEmpty()) {
            throw new StudentNotFoundException("student not found");
        }
        System.out.println("retrievedStudent : " + retrievedStudent);
        return retrievedStudent.get();
    }

    public List<Student> retrieveStudents() {
        return studentRepository.findAll();
    }

    public Map<Integer, Student> retrieveStudentsMap() {
        return studentRepository.findAllMap();
    }

    public List<Student> findStudentWithPagination(int page, int size) {
        List<Student> students = studentRepository.findStudentWithPagination(page, size);
        System.out.println("retrieved pagination data - " + students);
        return students;
    }
}
