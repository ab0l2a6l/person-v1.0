package model.repository;

import model.entity.Person;

import java.util.ArrayList;
import java.util.List;

public interface PersonDBRead {

    List<Person> findByall()throws Exception;

    Person findById(String id)throws Exception;

    void close()throws Exception;
}
