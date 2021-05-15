package com.example.ElectionDemo.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class PersistenceManager {
    private static final String PERSISTENCE_UNIT_NAME = "election";
    private static final PersistenceManager INSTANCE = new PersistenceManager();

    public static PersistenceManager getInstance() {
        return INSTANCE;
    }

    private final EntityManagerFactory emf;

    private PersistenceManager() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public void close() {
        if(emf.isOpen()) emf.close();
    }
}
