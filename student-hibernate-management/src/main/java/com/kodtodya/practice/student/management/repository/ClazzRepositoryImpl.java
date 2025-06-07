package com.kodtodya.practice.student.management.repository;

import com.kodtodya.practice.student.management.config.HibernateConfig;
import com.kodtodya.practice.student.management.exception.StudentNotFoundException;
import com.kodtodya.practice.student.management.model.Clazz;
import com.kodtodya.practice.student.management.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository("clazzRepository")
public class ClazzRepositoryImpl implements ClazzRepository {

    private final SessionFactory sessionFactory;

    public ClazzRepositoryImpl() {
        sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Clazz save(Clazz clazz) {
        Transaction tx = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.persist(clazz);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return clazz;
    }

    @Override
    public Set<Clazz> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from clazz");
        return (Set<Clazz>) query.list().stream().collect(Collectors.toSet());
    }

    @Override
    public Optional<Clazz> findById(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from clazz where id =" + id);
        Clazz clazz = (Clazz) query.uniqueResult();
        System.out.println("clazz:" + clazz.getId() + "|" + clazz.getClassName());
        return Optional.ofNullable(clazz);
    }

    @Override
    public Clazz deleteById(int id) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Clazz tobeDeletedClazz = (Clazz) session.load(Clazz.class, id);
        if (tobeDeletedClazz != null) {
            session.delete(tobeDeletedClazz);
        } else {
            throw new StudentNotFoundException("Clazz not found for id:" + id);
        }
        session.getTransaction().commit();
        session.flush();
        session.close();
        return tobeDeletedClazz;
    }

    @Override
    public Set<Clazz> findClazzWithPagination(int page, int size) {
        Session session = sessionFactory.openSession();
        return (Set<Clazz>) session.createQuery("from clazz")
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .list().parallelStream().collect(Collectors.toSet());
    }
}
