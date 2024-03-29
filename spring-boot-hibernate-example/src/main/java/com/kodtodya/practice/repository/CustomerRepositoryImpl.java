package com.kodtodya.practice.repository;

import com.kodtodya.practice.config.HibernateConfig;
import com.kodtodya.practice.domain.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

    private final SessionFactory sessionFactory;

    public CustomerRepositoryImpl() throws HibernateException {
        sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public Customer save(Customer customer) {
        // open the session
        Session session = sessionFactory.openSession();

        // For doing any CRUD operation,
        // let us start a transaction
        session.beginTransaction();
        session.save(customer);

        // commit will help to complete
        // the changes in the table
        session.getTransaction().commit();

        // close the session
        session.close();
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        // open the session
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Customer");
        List<Customer> response = query.list();

        return response;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        // open the session
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Customer where id = " + id);
        Customer customer = (Customer)query.uniqueResult();
        return Optional.ofNullable(customer);
    }

    @Override
    public void deleteById(Long id) {
        // open the session
        Session session = sessionFactory.openSession();

        // For doing any CRUD operation, let us start a transaction
        session.beginTransaction();
        Customer customer = (Customer) session.load(Customer.class, id);
        session.delete(customer);

        // commit will help to complete the changes in the table
        session.getTransaction().commit();

        session.flush();
        // close the session
        session.close();
    }
}
