package de.xrammit.insecurecode.service;

import de.xrammit.insecurecode.model.Person;

public interface AuthenticationProvider {

    boolean authenticate(Person personToAuthenticate, String authenticationInput);
}
