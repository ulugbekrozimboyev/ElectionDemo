package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.dao.implementation.CandidateDaoJpa;

import javax.persistence.EntityManagerFactory;

public final class DaoFactory {

    private static final DaoFactory INSTANCE = new DaoFactory();

    public static DaoFactory getInstance() {
        return INSTANCE;
    }

    private final EntityManagerFactory emf;

    private DaoFactory() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
    }

    public CandidateDao getCandidateDao() {
        return new CandidateDaoJpa(emf);
    }
}
