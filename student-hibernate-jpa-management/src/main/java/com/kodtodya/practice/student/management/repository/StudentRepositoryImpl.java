package com.kodtodya.practice.student.management.repository;

import com.kodtodya.practice.student.management.domain.StudentDomain;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<StudentDomain> findByCriteria(double percentage) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentDomain> query = cb.createQuery(StudentDomain.class);
        Root<StudentDomain> root = query.from(StudentDomain.class);

        List<Predicate> predicates = new ArrayList<>();

        if (percentage > 0) {
            predicates.add(cb.greaterThan(root.get("percentage"), percentage));
        }

        query.select(root).where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}
