package com.kodtodya.practice.student.management.repository;

import com.kodtodya.practice.student.management.config.HibernateConfig;
import com.kodtodya.practice.student.management.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository {

    private final SessionFactory sessionFactory;

    public StudentRepositoryImpl() {
        sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Student save(Student student) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();

        return student;
    }

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student");
        return query.list();
    }

    @Override
    public Optional<Student> findById(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student where id =" + id);
        Student student = (Student) query.uniqueResult();
        System.out.println("student:" + student.getName() + "|" + student.getPercentage());
        return Optional.ofNullable(student);
    }

    @Override
    public Student deleteById(int id) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Student tobeDeletedStudent = (Student) session.load(Student.class, id);
        session.delete(tobeDeletedStudent);
        session.getTransaction().commit();
        session.flush();
        session.close();
        return tobeDeletedStudent;
    }
}
