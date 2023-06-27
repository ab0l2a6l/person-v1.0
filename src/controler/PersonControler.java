package controler;

import model.service.PersonService;
import model.service.PersonServiceWrite;

public class PersonControler {
    PersonServiceWrite write = new PersonService();

    public void createTable() {
        write.createTable();
    }
}
