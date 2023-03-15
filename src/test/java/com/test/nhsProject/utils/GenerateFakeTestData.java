package com.test.nhsProject.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;


public class GenerateFakeTestData {
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

    private final String disease;
    private final String scoreDisease;
    private final String nameRoom;
    private final String userName;
    private final String password;
    private final String firstNamePatient;
    private final String lastNamePatient;
    private final String hospitalNo_Patient;
    private final String dateOfBirthPatient;
    private final String sexPatient;


    public GenerateFakeTestData() {
        Faker faker = new Faker();
        disease = faker.medical().diseaseName();
        scoreDisease = faker.number().digit();
        nameRoom = "Room " + faker.number().numberBetween(1, 800);
        userName = faker.name().username();
        password = faker.internet().password();
        firstNamePatient=faker.name().firstName();
        lastNamePatient=faker.name().lastName();
        hospitalNo_Patient= String.valueOf(faker.number().numberBetween(1,999999999));
        dateOfBirthPatient= sdf.format(faker.date().birthday());
        sexPatient=faker.demographic().sex();
    }

    public String getDisease() {
        return disease;
    }

    public String getScoreDisease() {
        return scoreDisease;
    }

    public String getNameRoom() { return nameRoom; }

    public String getUserName() { return userName; }

    public String getPassword() { return password; }

    public String getFirstNamePatient() { return firstNamePatient; }

    public String getLastNamePatient() { return lastNamePatient; }

    public String getHospitalNo_Patient() { return hospitalNo_Patient; }

    public String getDateOfBirthPatient() { return dateOfBirthPatient; }

    public String getSexPatient() { return sexPatient; }

}
