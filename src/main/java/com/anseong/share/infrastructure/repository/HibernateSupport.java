package com.anseong.share.infrastructure.repository;

import java.util.List;

import jakarta.persistence.EntityManager;

import org.hibernate.Session;

abstract class HibernateSupport<T> {

     EntityManager entityManager;

     HibernateSupport(EntityManager entityManager) {
          this.entityManager = entityManager;
     }

     Session getSession() {
          return entityManager.unwrap(Session.class);
     }

     public void save(T object) {
          entityManager.persist(object);
          entityManager.flush();
     }

     public void save(List<T> objects) {
          for (T object : objects) {
               entityManager.persist(object);
          }
          entityManager.flush();
     }

     public void remove(T object) {
          entityManager.remove(object);
          entityManager.flush();
     }

     public void remove(List<T> objects) {
          for (T object : objects) {
               entityManager.remove(object);
          }
          entityManager.flush();
     }
}
