package de.xrammit.insecurecode.model;

import de.xrammit.insecurecode.service.AuthenticationService;
import de.xrammit.insecurecode.service.RandomProvider;

import java.util.Date;

public class IdentificationFeature {    // non-final class, violates EXTEND-5 and OBJECT-5
    public String username;             // violates FUNDAMENTALS-6, EXTEND-1
    Date expirationDate;                // violates FUNDAMENTALS-6, EXTEND-1
    protected String secret;
    protected String password;

    public IdentificationFeature(String username) {
        this.username = username;
        this.setExpirationDate(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)));
        RandomProvider randomProvider = AuthenticationService.getRandomProvider();
        this.secret = String.valueOf(randomProvider.getRandomNumber());
        this.password = "foobar-" + randomProvider.getRandomNumber();
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
