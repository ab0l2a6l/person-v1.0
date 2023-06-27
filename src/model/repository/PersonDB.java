package model.repository;

import model.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDB implements PersonDBRead, PersonDBWrite {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDB() throws Exception {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb"
                , "root", "Am311865186");
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
        } catch (SQLSyntaxErrorException ignored) {
        }
    }

    @Override
    public void insert(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("insert into person2 values(? , ?)");
        preparedStatement.setString(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(String id) throws Exception {
        preparedStatement = connection.prepareStatement("delete from person2 where id = ?");
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("update  person2 set name=? where id =?");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Person> findByall() throws Exception {

        preparedStatement = connection.prepareStatement("select * from person2");
        ResultSet set = preparedStatement.executeQuery();

        List<Person> list = new ArrayList<>();
        while (set.next()) {
            Person person = new Person();
            person.setName(set.getString("name"));
            person.setId(set.getString("id"));
            list.add(person);
        }
        return list;
    }

    @Override
    public Person findById(String id) throws Exception {
        Person person = new Person();
        preparedStatement = connection.prepareStatement("select * from person2 where id = ?");
        preparedStatement.setString(1, id);
        ResultSet set = preparedStatement.executeQuery();
        if (set.next()) {
            person.setId(set.getString("id"));
            person.setName(set.getString("name"));
        }
        return person;
    }

    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
        System.out.println("disconnected");
    }
}
