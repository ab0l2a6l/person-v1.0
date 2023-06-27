package model.repository;

import model.entity.Person;

public interface PersonDBWrite {

    void createTable() throws Exception;

    void insert(Person person)throws Exception;

    void close()throws Exception;

}
