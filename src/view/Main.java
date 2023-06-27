package view;

import common.StaticScanner;
import controler.PersonControler;
import model.entity.Person;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = StaticScanner.getData();
        PersonControler personControler = new PersonControler();
        personControler.createTable();

        for (; ; ) {
            menu();
            int request = input.nextInt();
            input.nextLine();
            switch (request) {
                case 1 -> {
                    Person person = new Person();
                    System.out.print("insert name: ");
                    person.setName(input.nextLine());
                    System.out.print ("insert id: ");
                    person.setId(input.nextLine());

                    personControler.insert(person);
                }

                case 2 -> {
                    System.out.print ("insert id for delete: ");
                    personControler.delete(input.nextLine());
                }

                case 3 -> {
                    Person person = new Person();
                    System.out.print ("insert id for update: ");
                    person.setId(input.nextLine());
                    System.out.print ("insert new name: ");
                    person.setName(input.nextLine());

                    personControler.update(person);
                }

                case 4 -> {
                    System.out.println(personControler.findById(input.nextLine()));
                }

                case 5 -> {
                    List<Person> list = personControler.findByAll();
                    for (Person person : list) {
                        System.out.println(person);
                    }
                }

                case 6 -> {
                    return;
                }
                default -> System.out.println("wrong number!!!");
            }
        }
    }

    private static void menu() {
        System.out.println("1.insert");
        System.out.println("2.delete");
        System.out.println("3.update");
        System.out.println("4.search by id");
        System.out.println("5.show all");
        System.out.println("6.exit");
    }
}
