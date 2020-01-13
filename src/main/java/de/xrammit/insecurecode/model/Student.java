package de.xrammit.insecurecode.model;

import java.time.LocalDate;

public final class Student extends Person {
    private String matriculationNumber;

    public Student(String firstName, String lastName, LocalDate birthday, String matriculationNumber) {
        super(firstName, lastName, birthday);
        this.matriculationNumber = matriculationNumber;
    }
}
