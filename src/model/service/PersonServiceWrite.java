package model.service;

import model.entity.Person;

public interface PersonServiceWrite {
    void createTable();

    void insert(Person person);

    void delete(String id);

    void update(Person person);
}
