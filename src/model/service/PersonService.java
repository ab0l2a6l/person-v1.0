package model.service;

import model.repository.PersonDB;
import model.repository.PersonDBWrite;

public class PersonService implements PersonServiceWrite {
    PersonDBWrite write ;
    @Override
    public void createTable() {
        try {
            write = new PersonDB();
            write.createTable();
            write.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
