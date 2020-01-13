package de.xrammit.insecurecode.model;

import java.time.LocalDate;

public final class Professor extends Person {
    private String chair;

    public Professor(String firstName, String lastName, LocalDate birthday, String chair) {
        super(firstName, lastName, birthday);
        this.chair = chair;
    }
}
