package dao;

import entity.Person;

import java.util.List;

public interface PersonDao {
    Person getPerson(long personId);

    List<Person> getAllPersons();

//    <T> List<T> getAllPersons(Class<T> clazz);

    int addPerson(Person person);

    void deletePerson(long personId);

    void updatePerson(Person person);
}
