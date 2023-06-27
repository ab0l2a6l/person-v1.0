package model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLSyntaxErrorException;

public class PersonDB implements PersonDBRead , PersonDBWrite{

    private Connection connection ;
    private PreparedStatement preparedStatement;

    public PersonDB()throws Exception {
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb"
                 ,"root","Am311865186");
        System.out.println("connected");
    }

    @Override
    public void createTable() throws Exception {
       try {
            String query = "create table person2 (id varchar(20) not null , name varchar(20));";
            preparedStatement = connection.prepareStatement(query);
            //"create table person2 (? , ? );"
//        preparedStatement.setString(1,"id varchar(20) not null");
//        preparedStatement.setString(2,"name varchar(20) ");
            // preparedStatement.setString(3 , "primary key(id)");
            preparedStatement.executeUpdate();
            System.out.println("table created");
        }catch (SQLSyntaxErrorException ignored) {
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
        System.out.println("disconnected");
    }


}