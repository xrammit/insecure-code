package de.xrammit.insecurecode;

import de.xrammit.insecurecode.model.Person;
import de.xrammit.insecurecode.model.Professor;
import de.xrammit.insecurecode.model.Student;
import de.xrammit.insecurecode.service.AuthenticationService;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Professor("Max", "Mustermann", LocalDate.of(1972, Month.APRIL, 1), "Institute of Organic Chemistry"));
        people.add(new Student("Peter", "Müller", LocalDate.of(1998, Month.FEBRUARY, 12), "FOO-56789"));

        AuthenticationService authenticationService = new AuthenticationService();
        System.out.println("Authentication result of Max Mustermann: " + authenticationService.authenticatePerson(people.get(0), "foobar"));
    }
}
