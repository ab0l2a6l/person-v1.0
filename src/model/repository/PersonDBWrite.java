package model.repository;

public interface PersonDBWrite {

    void createTable() throws Exception;


    void close()throws Exception;

}
