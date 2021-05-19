package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.config.HibernateUtil;
import com.example.ElectionDemo.dto.CandidateDto;
import com.example.ElectionDemo.dto.QuestionDto;
import com.example.ElectionDemo.entities.Candidate;
import com.example.ElectionDemo.entities.Question;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 5:42 PM
 */
public class QuestionDao extends HibernateUtil {


    private static final String SQL_GET_QUESTIONS = "SELECT * FROM questions";
    private static final String SQL_INSERT = "INSERT INTO questions ( id, title) VALUES(nextval('questions_id_seq', :title )";

    public static final List<QuestionDto> questionList = new ArrayList<>(Arrays.asList(
            new QuestionDto(1L, " This is a question one"),
            new QuestionDto(2L, " This is a question two")
    ));

    public static List<QuestionDto> findAll() {
        Session session = getSessionFactory().openSession();
        session.getTransaction().begin();
        org.hibernate.query.Query<Question> query = session.createQuery("select  q from Question q order by q.id", Question.class);
        session.getTransaction().commit();
//        EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute("emf");
//        EntityManager em = emf.createEntityManager();
//        List<Question> list = em.createQuery(
//                "SELECT q FROM Question q", Question.class).getResultList();
//
//        List<QuestionDto> resultList = new ArrayList<>();
//        list.stream().forEach(q -> resultList.add(convertToDto(q)));
//        return resultList;

        return query.getResultList().stream().map(QuestionDao::convertToDto).collect(Collectors.toList());
    }

    private static QuestionDto convertToDto(Question question) {
        return new QuestionDto(question.getId(), question.getTitle());
    }

    private static Question convertToEntity(QuestionDto questionDto) {
        return new Question(questionDto.getId(), questionDto.getTitle());
    }

//    public static List<QuestionDto> findAll() {
//        List<QuestionDto> list = new ArrayList<>();
//        try {
//
//            Connection connection = DBManager.getConnection();
//            Statement statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery(SQL_GET_QUESTIONS);
//            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String title = resultSet.getString(2);
//                list.add(new QuestionDto(id, title));
//            }
//
//            resultSet.close();
//            statement.close();
//            connection.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }

//    public static List<QuestionDto> findAll() {
//        return questionList;
//    }

    public static void save(QuestionDto questionDto) {
        Question question = convertToEntity(questionDto);
        Session session = getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(question);
        session.getTransaction().commit();
        System.out.println(question);

    }

//    public static void save(QuestionDto questionDto) {
//        try {
//
//            Connection connection = DBManager.getConnection();
//            Statement statement = connection.createStatement();
//
//            statement.executeQuery(SQL_INSERT).;
//
//
//            resultSet.close();
//            statement.close();
//            connection.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }

    public static void delete(Long id) {
        Session session = getSessionFactory().openSession();
        session.getTransaction().begin();
        Question load = session.load(Question.class, id);
        System.out.println(load);
        session.delete(load);
        session.getTransaction().commit();
    }

    public static Optional<QuestionDto> findById(Long id) {
        Session session = getSessionFactory().openSession();

        org.hibernate.query.Query<Question> query = session.createQuery("select q  from  Question q where q.id = :id", Question.class);
        query.setParameter("id", id);
        Optional<Question> result = query.stream().findFirst();
        return result.map(QuestionDao::convertToDto);
    }

    public static void update(QuestionDto questionDto) {
        Question question = convertToEntity(questionDto);
        Session session = getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(question);
        session.getTransaction().commit();
    }
}
