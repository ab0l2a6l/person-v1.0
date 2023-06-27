package model.service;

import model.entity.Person;

import java.util.List;

public interface PersonServiceRead {

    List<Person> findByall();

    Person findById(String id);
}
