package com.zuev.repositories.sqlimpl;

import com.zuev.entities.Label;
import com.zuev.repositories.LabelRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlLabelRepositoryImpl implements LabelRepository {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crudappdata";

    List<Label> labels = new ArrayList<>();

    public MySqlLabelRepositoryImpl() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Label getByld(Long aLong) {
        Label labelById;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        String sql = null;
        int id;
        String name = null;
        try {
            sql = "select * from labels where label_id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, aLong);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()){
                id = resultSet.getInt("label_id");
                name = resultSet.getString("name");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        return labelById = new Label(name);
    }

    @Override
    public List<Label> getAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Label newLabel = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sql = null;
        try {
            sql = "select * from labels";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while(resultSet.next()){
                newLabel = new Label();
                newLabel.setId(resultSet.getInt("label_id"));
                newLabel.setName(resultSet.getString("name"));

                labels.add(newLabel);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        return labels;
    }

    @Override
    public Label save(Label label) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sql;

        try {
            sql = "insert into labels (name) values(?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, label.getName());
            preparedStatement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return label;
    }

    @Override
    public Label update(Label label) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql;

        try {
            sql = "update labels set name = ? where label_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, label.getName());
            preparedStatement.setLong(2, label.getId());
            preparedStatement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void deleteByld(Long aLong) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql;

        try {
            sql = "delete from labels where label_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, aLong);
            preparedStatement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
