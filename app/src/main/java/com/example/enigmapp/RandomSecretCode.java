package com.example.enigmapp;

import java.util.Random;

public class RandomSecretCode {

    private String randomCode = "";

    public RandomSecretCode(int numberOfCharacters) {

        for (int y = 0; y < numberOfCharacters; y++) {

            Random ran = new Random();
            randomCode = randomCode + (char) (ran.nextInt(95) + 32);
        }

    }

    public String getSecretCode() {
        return randomCode;
    }

}
