package de.xrammit.insecurecode.service;

import de.xrammit.insecurecode.model.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class AuthenticationService {
    public static final Date MINIMUM_VALIDITY_DATE = new Date(System.currentTimeMillis() + (1000 * 60 * 60));   // mutable public static final field, violates MUTABLE-10
    private static final List<AuthenticationProvider> AUTHENTICATION_PROVIDERS;
    private static final RandomProvider RANDOM_PROVIDER = new RandomProvider();
    static {
        AUTHENTICATION_PROVIDERS = new ArrayList<>();
        AUTHENTICATION_PROVIDERS.add(new PasswordAuthenticationProvider());
        AUTHENTICATION_PROVIDERS.add(new SecretAuthenticationProvider());
    }

    public boolean authenticatePerson(Person personToAuthenticate, String authenticationInput) {
        if (personToAuthenticate.getIdentificationFeature().getExpirationDate().before(MINIMUM_VALIDITY_DATE)) {
            return false;
        }
        for (AuthenticationProvider provider : AUTHENTICATION_PROVIDERS) {
            boolean authenticationResult = provider.authenticate(personToAuthenticate, authenticationInput);
            if (authenticationResult) {
                return true;
            }
        }
        return false;
    }

    public static List<AuthenticationProvider> getAuthenticationProviders() {
        return AUTHENTICATION_PROVIDERS;     // return reference to a mutable list, violates MUTABLE-12
    }

    public static RandomProvider getRandomProvider() {
        return RANDOM_PROVIDER;     // exposes mutable static field, violates MUTABLE-11
    }
}
