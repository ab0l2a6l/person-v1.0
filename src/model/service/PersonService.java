package model.service;

import model.entity.Person;
import model.repository.PersonDB;
import model.repository.PersonDBRead;
import model.repository.PersonDBWrite;

import java.util.List;

public class PersonService implements PersonServiceWrite, PersonServiceRead {
    PersonDBWrite write;
    PersonDBRead read;

    @Override
    public void createTable() {
        try {
            write = new PersonDB();
            write.createTable();
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Person person) {
        try {
            write = new PersonDB();
            write.insert(person);
            write.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        try {
            write = new PersonDB();
            write.delete(id);
            write.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Person person) {
        try {
            write = new PersonDB();
            write.update(person);
            write.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Person> findByall() {
        List<Person> list = null;
        try {
            read = new PersonDB();
            list = read.findByall();
            read.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Person findById(String id) {
        Person person = null;
        try {
            read = new PersonDB();
            person = read.findById(id);
            read.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return person;
    }
}
