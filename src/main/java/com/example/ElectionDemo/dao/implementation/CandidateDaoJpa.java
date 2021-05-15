package com.example.ElectionDemo.dao.implementation;

import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dto.CandidateDto;
import com.example.ElectionDemo.errors.UnknownItemException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CandidateDaoJpa implements CandidateDao {
    private final EntityManagerFactory emf;

    public CandidateDaoJpa(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<CandidateDto> findAll() {
        List<CandidateDto> result = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT s FROM candidates s");
            result.addAll(query.getResultList());
        } finally {
            em.close();
        }

        return result;
    }

    @Override
    public Optional<CandidateDto> findById(Long id) {
        EntityManager em = emf.createEntityManager();

        try {
            CandidateDto result = em.find(CandidateDto.class, id);

            if(result == null) return Optional.empty();

            return Optional.of(result);
        }
        finally {
            em.close();
        }
    }

    @Override
    public void save(CandidateDto candidate) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            if(em.find(CandidateDao.class, candidate.getId()) != null) {
                em.merge(candidate);
            } else {
                em.persist(candidate);
            }

            em.getTransaction().commit();
        }
        finally {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            CandidateDto candidate = em.find(CandidateDto.class, id);

            if(candidate != null) {
                em.remove(candidate);
                em.getTransaction().commit();
                return;
            }

            throw new UnknownItemException(CandidateDto.class, id);
        }
        finally {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            em.close();
        }
    }
}
