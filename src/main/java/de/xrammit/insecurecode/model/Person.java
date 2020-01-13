package de.xrammit.insecurecode.model;

import java.io.File;
import java.time.LocalDate;

public class Person {
    protected String firstName;
    protected String lastName;
    protected LocalDate birthday;
    protected String profilePictureFilename;
    private IdentificationFeature identificationFeature;

    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.identificationFeature = new IdentificationFeature(firstName.toLowerCase() + "." + lastName.toLowerCase());
        refreshIdentificationFeature();     // violates OBJECT-4
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void updateProfilePicture(String filename, byte[] payload) {
        PersonUtils.storeProfilePictureWithFilename(filename, payload);
    }

    public File getProfilePictureFile() {
        return new File(PersonUtils.PROFILE_PICTURE_BASE_DIRECTORY, profilePictureFilename);
    }

    public IdentificationFeature getIdentificationFeature() {   // violates MUTABLE-2
        return identificationFeature;
    }

    protected void refreshIdentificationFeature() {
        // ToDo increase refresh interval to produce numeric overflow
        identificationFeature.expirationDate.setTime(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 5));
    }

    public boolean verifyPassword(String input) {                    // non-final, violates EXTEND-5
        return input.equals(identificationFeature.getPassword());
    }

    public final boolean verifySecret(String input) {
        return input.equals(identificationFeature.getSecret());
    }
}
