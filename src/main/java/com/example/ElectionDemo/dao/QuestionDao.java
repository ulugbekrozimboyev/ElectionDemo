package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.dto.QuestionDto;
import com.example.ElectionDemo.entities.Question;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import java.util.*;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 5:42 PM
 */
public class QuestionDao {


    private static final String SQL_GET_QUESTIONS = "SELECT * FROM questions";
    private static final String SQL_INSERT = "INSERT INTO questions ( id, title) VALUES(nextval('questions_id_seq', :title )";

    public static final List<QuestionDto> questionList = new ArrayList<>(Arrays.asList(
            new QuestionDto(1L," This is a question one"),
            new QuestionDto(2L," This is a question two")
    ));

    public static List<QuestionDto> findAll(ServletContext context){
//        EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute("emf");
//        EntityManager em = emf.createEntityManager();
//        List<Question> list = em.createQuery(
//                "SELECT q FROM Question q", Question.class).getResultList();
//
//        List<QuestionDto> resultList = new ArrayList<>();
//        list.stream().forEach(q -> resultList.add(convertToDto(q)));
//        return resultList;

        return questionList;
    }

    private static QuestionDto convertToDto(Question question){
        return new QuestionDto(question.getId(), question.getTitle());
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
        questionDto.setId((long) (questionList.size() + 1));
        questionList.add(questionDto);
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
        questionList.removeIf(questionDto -> Objects.equals(questionDto.getId(), id));
    }

    public static Optional<QuestionDto> findById(Long id) {
        return questionList.stream().filter(item -> Objects.equals(item.getId(), id)).findFirst();
    }

    public static void update(QuestionDto questionDto) {
        for (QuestionDto dto : questionList) {
            if (Objects.equals(dto.getId(), questionDto.getId())) {
                dto.setTitle(questionDto.getTitle());
            }
        }
    }
}
