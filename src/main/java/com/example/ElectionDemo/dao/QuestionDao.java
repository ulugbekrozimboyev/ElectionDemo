package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.dto.QuestionDto;

import java.sql.*;
import java.util.*;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 5:42 PM
 */
public class QuestionDao {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/servlets_tutorial";
    static final String DATABASE_USER = "postgres";
    static final String DATABASE_PASSWORD = "postgres";
    static final String GET_ALL_DEVELOPERS_RECORDS = "SELECT * FROM questions";

    public static final List<QuestionDto> questionList = new ArrayList<>(Arrays.asList(
            new QuestionDto(1L," This is a question one"),
            new QuestionDto(2L," This is a question two")
    ));

    public static List<QuestionDto> findAllJpa() {
        List<QuestionDto> list = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(GET_ALL_DEVELOPERS_RECORDS);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                list.add(new QuestionDto(id, title));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<QuestionDto> findAll() {
        return questionList;
    }

    public static void save(QuestionDto questionDto) {
        questionDto.setId((long) (questionList.size() + 1));
        questionList.add(questionDto);
    }

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
