package com.zuev.repositories.sqlimpl;

import com.zuev.entities.Label;
import com.zuev.entities.Post;
import com.zuev.entities.Writer;
import com.zuev.repositories.WriterRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlWriterRepositoryImpl implements WriterRepository {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crudappdata";
    @Override
    public Writer getByld(Integer integer) {
        Writer writer = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = null;


        try {
            sql = "select * from writers where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");

                writer = new Writer(id, firstName, lastName);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return writer;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writers = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = null;

        sql = "select * from writers";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");

                writers.add(new Writer(id, firstName, lastName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return writers;
    }

    @Override
    public Writer save(Writer writer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = null;
        sql = "insert into writers (FirstName, LastName) values (?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, writer.getFirstName());
            preparedStatement.setString(2, writer.getLastName());
            preparedStatement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Writer update(Writer writer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = null;
        try {
            sql = "update writers set FirstName = ?, LastName = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, writer.getFirstName());
            preparedStatement.setString(2, writer.getLastName());
            preparedStatement.setInt(3, writer.getId());
            preparedStatement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void deleteByld(Integer integer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = null;

        try {
            sql = "delete from writers where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, integer);
            preparedStatement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
