package com.kodtodya.practice.repository;

import com.kodtodya.practice.config.HibernateConfig;
import com.kodtodya.practice.domain.Artist;
import com.kodtodya.practice.domain.Song;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository("songRepository")
public class SongRepository implements EntityRepository<Song> {

    @Autowired
    private ArtistRepository artistRepository;

    private final SessionFactory sessionFactory;

    public SongRepository() throws HibernateException {
        sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public Song save(Song song) {
        // open the session
        Session session = sessionFactory.openSession();

        // For doing any CRUD operation, let us start a transaction
        session.beginTransaction();

//        Set<Artist> artists = song.getArtists();
//        Set<Artist> artistList = new HashSet<>();
//        artists.stream().forEach(artist -> {
//            Optional<Artist> dbArtist = artistRepository.findByName(artist.getName());
//            if (dbArtist.isPresent()) {
//                artistList.add(dbArtist.get());
//            }
//        });
//
//        song.setArtists(artistList);
        //session.persist(song);
        session.save(song);

        // commit will help to complete the changes in the table
        session.getTransaction().commit();

        // close the session
        session.close();
        return song;
    }

    @Override
    public List<Song> findAll() {
        // open the session
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Song");

        // simple pagination
        query.setFirstResult(0);
        query.setMaxResults(3);
        List<Song> response = query.list();

        return response;
    }

    @Override
    public Optional<Song> findById(Long id) {
        // open the session
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Song where id = " + id);
        Song song = (Song)query.uniqueResult();
        return Optional.ofNullable(song);
    }

    @Override
    public Optional<Song> findByName(String name) {
        // open the session
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Song where name = :name");
        query.setString("name", name);
        Song song = (Song)query.uniqueResult();
        return Optional.ofNullable(song);
    }

    @Override
    public Set<Song> findByAttribute(String value) {
        // open the session
        Session session = sessionFactory.openSession();

//        Query query = session.createQuery("from Song where lyrics like %" + value + "%");
//        Song song = (Song)query.uniqueResult();
//        return Optional.ofNullable(song);
        Criteria cr = session.createCriteria(Song.class);
        cr.add(Restrictions.like("lyrics", value));
        return new HashSet<Song>(cr.list());
    }

    @Override
    public void deleteById(Long id) {
        // open the session
        Session session = sessionFactory.openSession();

        // For doing any CRUD operation, let us start a transaction
        session.beginTransaction();
        Song song = (Song) session.load(Song.class, id);
        session.delete(song);

        // commit will help to complete the changes in the table
        session.getTransaction().commit();

        session.flush();
        // close the session
        session.close();
    }
}
