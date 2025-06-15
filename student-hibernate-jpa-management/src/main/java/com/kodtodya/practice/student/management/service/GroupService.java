package com.kodtodya.practice.student.management.service;

import com.kodtodya.practice.student.management.domain.GroupDomain;
import com.kodtodya.practice.student.management.domain.StudentDomain;
import com.kodtodya.practice.student.management.exception.StudentNotFoundException;
import com.kodtodya.practice.student.management.model.Group;
import com.kodtodya.practice.student.management.model.Student;
import com.kodtodya.practice.student.management.model.StudentGroup;
import com.kodtodya.practice.student.management.model.StudentGroupProjection;
import com.kodtodya.practice.student.management.repository.GroupRepository;
import com.kodtodya.practice.student.management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentService studentService;

    public Group createGroup(Group group) {
        System.out.println("Inside service: " + group);
        GroupDomain domain = this.populateDomain(group);
        return this.populateModel(groupRepository.save(domain));
    }

    public List<StudentGroupProjection> fetchStudentGroupById(int id) {
        System.out.println("Inside service: " + id);
        return groupRepository.findStudentGroupProjectionById(id);
    }

//    public Student deleteStudent(int id) {
//        Optional<StudentDomain> domain = studentRepository.findById(id);
//        if (!domain.isEmpty()) {
//            studentRepository.deleteById(id);
//            System.out.println("Deleted student: " + domain.get());
//        } else {
//            throw new StudentNotFoundException("Student not found");
//        }
//        return this.populateModel(domain.get());
//    }
//
//    public Student retrieveStudent(int id) {
//        Optional<StudentDomain> retrievedStudent = studentRepository.findById(id);
//        if (retrievedStudent.isEmpty()) {
//            throw new StudentNotFoundException("student not found");
//        }
//        System.out.println("retrievedStudent : " + retrievedStudent);
//        return this.populateModel(retrievedStudent.get());
//    }
//
//    public List<Student> retrieveStudents() {
//        return studentRepository.findAll().stream()
//                .map(this::populateModel).toList();
//    }

    private Group populateModel(GroupDomain domain) {
        Set<Student> studentList = domain.getStudents().parallelStream()
                .map(studentService::populateModel)
                .collect(Collectors.toSet());
        return Group.builder()
                .id(domain.getId())
                .name(domain.getName())
                .students(studentList)
                .build();
    }

    private GroupDomain populateDomain(Group model) {
        Set<StudentDomain> studentList = model.getStudents().parallelStream()
                .map(studentService::populateDomain)
                .collect(Collectors.toSet());
        return GroupDomain.builder()
                .id(model.getId())
                .name(model.getName())
                .students(studentList)
                .build();
    }
}
