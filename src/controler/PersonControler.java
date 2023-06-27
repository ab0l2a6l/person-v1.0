package controler;

import model.entity.Person;
import model.service.PersonService;
import model.service.PersonServiceRead;
import model.service.PersonServiceWrite;

import java.util.List;

public class PersonControler {
    PersonServiceWrite write = new PersonService();
    PersonServiceRead read = new PersonService();

    public void createTable() {
        write.createTable();
    }

    public void insert(Person person) {
        write.insert(person);
    }

    public void delete(String id) {
        write.delete(id);
    }

    public void update(Person person) {
        write.update(person);
    }

    public Person findById(String id) {
        return  read.findById(id);
    }

    public List<Person> findByAll() {
        return read.findByall();
    }
}
