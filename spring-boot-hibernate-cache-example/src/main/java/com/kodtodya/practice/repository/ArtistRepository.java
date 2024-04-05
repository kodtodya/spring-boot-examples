package com.kodtodya.practice.repository;

import com.kodtodya.practice.config.HibernateConfig;
import com.kodtodya.practice.domain.Artist;
import com.kodtodya.practice.domain.Song;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository("artistRepository")
public class ArtistRepository implements EntityRepository<Artist> {

    private final SessionFactory sessionFactory;

    public ArtistRepository() throws HibernateException {
        sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public Artist save(Artist artist) {
        // open the session
        Session session = sessionFactory.openSession();

        // For doing any CRUD operation, let us start a transaction
        session.beginTransaction();
        session.save(artist);

        // commit will help to complete the changes in the table
        session.getTransaction().commit();

        // if you have multiple object to be persisted, pls use clear/flush
        session.clear();

        // close the session
        session.close();
        return artist;
    }

    public Artist update(Artist artist) {
        // open the session
        Session session = sessionFactory.openSession();

        // For doing any CRUD operation, let us start a transaction
        session.beginTransaction();
        session.saveOrUpdate(artist);

        // commit will help to complete the changes in the table
        session.getTransaction().commit();

        // close the session
        session.close();
        return artist;
    }

    @Override
    public List<Artist> findAll() {
        // open the session
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Artist");
        List<Artist> response = query.list();

        return response;
    }

    @Override
    public Optional<Artist> findById(Long id) {
        // open the session
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Artist where id = " + id);
        Artist artist = (Artist)query.uniqueResult();
        return Optional.ofNullable(artist);
    }

    @Override
    public Optional<Artist> findByName(String name) {
        // open the session
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Artist where name = :name");
        query.setString("name", name);
        Artist artist = (Artist)query.uniqueResult();
        return Optional.ofNullable(artist);
    }

    @Override
    public Set<Artist> findByAttribute(String value) {
        // open the session
        Session session = sessionFactory.openSession();

//        Query query = session.createQuery("from Artist where city like %" + value + "%");
//        Artist artist = (Artist)query.uniqueResult();
//        return Optional.ofNullable(artist);

        Criteria cr = session.createCriteria(Artist.class);
        cr.add(Restrictions.eq("city", value));
        return new HashSet<Artist>(cr.list());
    }

    @Override
    public void deleteById(Long id) {
        // open the session
        Session session = sessionFactory.openSession();

        // For doing any CRUD operation, let us start a transaction
        session.beginTransaction();
        Artist artist = (Artist) session.load(Artist.class, id);
        session.delete(artist);

        // commit will help to complete the changes in the table
        session.getTransaction().commit();

        session.flush();

        // remove artist object from cache
        session.evict(artist);

        // close the session
        session.close();
    }
}
