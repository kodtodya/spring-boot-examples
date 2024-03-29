package com.kodtodya.practice.config;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

  @Getter
  private static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {
    try {
      // We need to create the SessionFactory from hibernate.cfg.xml
      return new Configuration()
              .configure()
              .buildSessionFactory();
    }
    catch (Throwable ex) {
      // Make sure you log the exception, as it might be swallowed
      // In case of any exception, it has to be indicated here
      System.err.println("SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static void shutdown() {
    // Close caches and connection pools
    getSessionFactory().close();
  }
}
