package com.example.ElectionDemo.dao.implementation;

import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dto.CandidateDto;
import com.example.ElectionDemo.dto.ItemParam;
import com.example.ElectionDemo.errors.UnknownItemException;

import javax.persistence.*;
import javax.persistence.criteria.*;
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
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<CandidateDto> cq = cb.createQuery(CandidateDto.class);
//            Root<CandidateDto> root = cq.from(CandidateDto.class);
//            Join<CandidateDto, ItemParam> items = root.join("params", JoinType.LEFT);

//            Query query = em.createNativeQuery("select c.id, c.full_name, c.current_job, c.about, " +
//                    "ccp.candidatedto_id, ccp.params_id, cp.id, cp.key, cp.value from candidates c\n" +
//                    "left join candidates_candidate_params ccp on ccp.candidatedto_id = c.id\n" +
//                    "left join candidate_params cp on cp.id = ccp.params_id;");

            Query query = em.createNativeQuery("select * from candidates", CandidateDto.class);
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

            if(em.find(CandidateDto.class, candidate.getId()) != null) {
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
