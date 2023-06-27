package view;

import controler.PersonControler;

public class Main {
    public static void main(String[] args) {
        PersonControler personControler = new PersonControler();
        personControler.createTable();
    }
}
