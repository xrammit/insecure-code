package de.xrammit.insecurecode.service;

import de.xrammit.insecurecode.model.Person;

final class PasswordAuthenticationProvider implements AuthenticationProvider {

    @Override
    public boolean authenticate(Person personToAuthenticate, String authenticationInput) {
        if (personToAuthenticate.verifyPassword(authenticationInput)) {
            return true;
        } else {
            logFailure(personToAuthenticate, String.format("Input '%s' does not match password '%s'", authenticationInput,
                    personToAuthenticate.getIdentificationFeature().getPassword()));     // logs password, violates CONFIDENTIAL-2
            return false;
        }
    }

    private static void logFailure(Person person, String message) {     // duplicate method, violates FUNDAMENTALS-2
        System.out.println(String.format("Authentication failed for person with username %s with reason: %s",
                person.getIdentificationFeature().username, message));  // logs username, violates CONFIDENTIAL-2
    }
}
