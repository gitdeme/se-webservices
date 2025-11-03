package org.wldu.webservices.repositories;

import com.wldu.xsdgenerated.Person;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepository {
    private final Map<String, Person> database = new HashMap<>();

    public Person create(Person person) {
        String key = person.getFirstName() + "_" + person.getLastName();
        database.put(key, person);
        return person;
    }

    public Person read(String firstName, String lastName) {
        return database.get(firstName + "_" + lastName);
    }

    public Person update(Person person) {
        String key = person.getFirstName() + "_" + person.getLastName();
        database.put(key, person);
        return person;
    }

    public boolean delete(String firstName, String lastName) {
        return database.remove(firstName + "_" + lastName) != null;
    }

    public Collection<Person> listAll() {
        return database.values();
    }
}