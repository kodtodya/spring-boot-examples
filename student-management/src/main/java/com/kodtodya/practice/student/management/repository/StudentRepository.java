package com.kodtodya.practice.student.management.repository;

import com.kodtodya.practice.student.management.model.Student;
import com.kodtodya.practice.student.management.model.StudentUpdate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer, Student> data = new HashMap<>();

    public Student createStudent(Student student) {
        System.out.println("Inside repo: " + student);
        data.put(student.getId(), student);
        //data.put(student.id, student);
        System.out.println("All student data:");
        data.entrySet().parallelStream()
                .forEach(entry -> System.out.println("Key: " + entry.getKey() + "|Value: " + entry.getValue()));
        return student;
    }

    public Student deleteStudent(int id) {
        return data.remove(id);
    }

    public Student retrieveStudent(int id) {
        return data.get(id);
    }

    public List<Student> retrieveStudent(String name) {
        return data.values()
                .parallelStream()
                .filter( student -> student.getName().equalsIgnoreCase(name))
                .toList();
    }

    public Map<Integer, Student> retrieveStudents() {
        return data;
    }

    public Student updatePartialStudent(int id, StudentUpdate newStudent) {
        Student studentToBeUpdated = data.get(id);

        if (!newStudent.name().isEmpty()) {
            studentToBeUpdated.setName(newStudent.name());
        }
        if (newStudent.percentage() != studentToBeUpdated.getPercentage() && newStudent.percentage() > 0) {
            studentToBeUpdated.setPercentage(newStudent.percentage());
        }
//        else {
//            studentToBeUpdated.setPercentage(studentToBeUpdated.getPercentage());
//        }
        return data.get(id);
    }

    public Student updateFullStudent(int id, StudentUpdate student) {
        Student studentToBeUpdated = data.get(id);
        studentToBeUpdated.setName(student.name());
        studentToBeUpdated.setPercentage(student.percentage());
        return data.get(id);
    }
}
