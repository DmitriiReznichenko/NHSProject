package com.test.nhsProject.utils;

import com.github.javafaker.Faker;

public class GenerateFakeTestData {
    private final String disease;
    private final String scoreDisease;

    private final String nameRoom;

    public GenerateFakeTestData() {
        Faker faker = new Faker();
        disease = faker.medical().diseaseName();
        scoreDisease = faker.number().digit();
        nameRoom = "Room "+faker.number().numberBetween(1,800);
    }

    public String getDisease() {
        return disease;
    }

    public String getScoreDisease() {
        return scoreDisease;
    }

    public String getNameRoom() { return nameRoom;}


}
