package com.test.nhsProject.utils;

import com.github.javafaker.Faker;

public class GenerateFakeTestData {
    private final String disease;
    private final String scoreDisease;
    public GenerateFakeTestData(){
        Faker faker=new Faker();
        disease=faker.medical().diseaseName();
        scoreDisease=faker.number().digit();
    }

    public String getDisease() {
        return disease;
    }
    public String getScoreDisease() {
        return scoreDisease;
    }




}
