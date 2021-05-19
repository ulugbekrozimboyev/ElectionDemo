package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.config.HibernateUtil;
import com.example.ElectionDemo.dto.CandidateDto;
import com.example.ElectionDemo.entities.Candidate;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.*;
import java.util.stream.Collectors;

public class CandidateDao extends HibernateUtil {

    public static void save(CandidateDto candidateDto) {
        Session session = getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(convertToEntity(candidateDto));
        session.getTransaction().commit();
    }

    public static Optional<CandidateDto> findById(Long id) {
        Session session = getSessionFactory().openSession();
        NativeQuery<Candidate> candidate = session.createNativeQuery("select c from candidate c where id = :id", Candidate.class);
        candidate.setParameter("id", id);
        Optional<Candidate> optionalCandidate = candidate.stream().findFirst();
        return optionalCandidate.map(CandidateDao::convertToDto);
    }
    public static Optional<CandidateDto> findByFullName(String username) {
        Session session = getSessionFactory().openSession();
        NativeQuery<Candidate> nativeQuery = session.createNativeQuery("select c from candidate c where c.fullname =:fullName", Candidate.class);
        nativeQuery.setParameter("fullName", username);
        Optional<Candidate> result = nativeQuery.stream().findFirst();
        return result.map(CandidateDao::convertToDto);
    }

    public static List<CandidateDto> findAll() {
        Session session = getSessionFactory().openSession();
        Query<Candidate> query = session.createQuery("select c from Candidate c", Candidate.class);
        return query.getResultList().stream().map(CandidateDao::convertToDto).collect(Collectors.toList());
    }

    public static boolean existCandidate(String username) {
        return findByFullName(username).isPresent();
    }

    public static void update(CandidateDto candidateDto) {
        Session session = getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(convertToEntity(candidateDto));
        session.getTransaction().commit();
    }

    public static void delete(Long id) {
        Session session = getSessionFactory().openSession();
        NativeQuery nativeQuery = session.createNativeQuery("delete from candidate c where c.id = :id");
        nativeQuery.setParameter("id", id);
        nativeQuery.executeUpdate();
    }


    private static Candidate convertToEntity(CandidateDto candidateDto) {
        return new Candidate(candidateDto.getId(), candidateDto.getFullName(), candidateDto.getCurrentJob(), candidateDto.getAbout(), candidateDto.getMoreInformation());
    }

    private static CandidateDto convertToDto(Candidate candidateDto) {
        return new CandidateDto(candidateDto.getId(), candidateDto.getFullName(), candidateDto.getCurrentJob(), candidateDto.getAbout(), candidateDto.getMoreInformation());
    }

}
