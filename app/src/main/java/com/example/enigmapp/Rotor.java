package com.example.enigmapp;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;



public class Rotor {
    private   BiMap<String, String> rotor0 = HashBiMap.create();


    /**
     * Setting up the character mixing device. This class requires Google Guava
     * BiMap and HashBiMap.
     *
     * @param initialCode
     *            A string of 4 characters. They are the initial rotors 1-4 position
     * @param rotorNumber
     *            A number of rotor that is being used in given time
     * @param characterNumber
     *            A number of character in given text
     */


    public Rotor(String initialCode, int rotorNumber, int characterNumber) {



         Queue<String> rotor1QueKeys = new LinkedList<>();
         Queue<String> rotor1QueValues = new LinkedList<>();
         List<String> temp = new ArrayList<>();


        int[] rotor = {32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126};
        int[] rotor1 ={85,38,45,126,64,101,63,96,95,114,103,83,60,65,34,119,43,57,121,91,55,108,47,46,97,88,77,61,106,48,59,109,122,125,36,69,100,39,110,81,70,115,111,32,52,50,79,33,41,99,87,118,67,56,90,117,74,120,92,78,71,89,98,80,58,102,123,94,86,76,116,66,68,75,73,49,51,113,93,42,37,84,54,124,44,40,53,107,105,82,104,112,72,35,62};

        int[] rotor2 ={32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126};
        int[] rotor3 ={57,66,95,80,101,47,93,60,96,126,108,122,52,120,38,77,41,125,85,56,84,54,110,82,49,76,34,118,39,68,69,33,36,81,105,45,116,89,42,121,50,100,124,59,112,99,113,111,97,83,64,51,43,102,104,37,91,94,109,79,67,46,73,72,123,44,78,75,106,115,40,65,53,74,63,55,71,107,114,90,32,98,62,87,117,88,70,61,92,103,58,35,86,119,48};

        int[] rotor4 ={32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126};
        int[] rotor5 ={77,72,60,88,92,68,39,69,33,105,87,44,73,71,75,123,76,66,108,125,32,53,122,102,84,48,106,52,104,41,36,45,109,110,63,115,97,35,40,114,51,55,100,62,50,112,49,67,124,90,98,113,93,116,85,107,99,111,126,58,120,79,82,47,56,118,86,83,54,46,42,74,70,89,34,119,101,81,37,121,78,103,43,80,65,38,64,94,57,95,91,96,117,59,61};

        int[] rotor6 ={32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126};
        int[] rotor7 ={126,125,124,123,122,121,120,119,118,117,116,115,114,113,112,111,110,109,108,107,106,105,104,103,102,101,100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32};




        if (rotorNumber == 1) {
            rotorNumber = 0;


            for (int x = 0; x < 95; x++) {
                rotor1QueKeys.add(Integer.toString(rotor[x]));
                rotor1QueValues.add(Integer.toString(rotor1[x]));
                  temp.add(Integer.toString(rotor1[x]));


            }

        } else if (rotorNumber == 2) {
            rotorNumber = 2;


            for (int x = 0; x < 95; x++) {
                rotor1QueKeys.add(Integer.toString(rotor2[x]));
                rotor1QueValues.add(Integer.toString(rotor3[x]));
                 temp.add(Integer.toString(rotor3[x]));


            }

        } else if (rotorNumber == 3) {
            rotorNumber = 4;


            for (int x = 0; x < 95; x++) {
                rotor1QueKeys.add(Integer.toString(rotor4[x]));
                rotor1QueValues.add(Integer.toString(rotor5[x]));
                  temp.add(Integer.toString(rotor5[x]));


            }

        } else if (rotorNumber == 4) {
            rotorNumber = 6;


            for (int x = 0; x < 95; x++) {
                rotor1QueKeys.add(Integer.toString(rotor6[x]));
                rotor1QueValues.add(Integer.toString(rotor7[x]));
                  temp.add(Integer.toString(rotor7[x]));


            }

        }








        // rotating the rotor 1
        if (rotorNumber == 0) {
            characterNumber = characterNumber % 95; // rotating only by the reminder of rotor lenght devided by
            // number of characters

            for (int x = 0; x < temp.indexOf(initialCode) + characterNumber; x++) { // rotating

                rotor1QueValues.add(rotor1QueValues.poll());

            }
            // rotating the rotor 2
        } else if (rotorNumber == 2) {
            // this one rotates by one after first one makes a full cycle
            characterNumber = (int) characterNumber / 95;

            for (int x = 0; x < temp.indexOf(initialCode) + characterNumber; x++) { // rotating

                rotor1QueValues.add(rotor1QueValues.poll());

            }

        } else if (rotorNumber == 4) {
            // this one rotates by one after second one makes a full cycle
            characterNumber = (int) characterNumber / 9025;

            for (int x = 0; x < temp.indexOf(initialCode) + characterNumber; x++) { // rotating

                rotor1QueValues.add(rotor1QueValues.poll());

            }
        } else if (rotorNumber == 6) {
            // this one is static

            for (int x = 0; x < 95; x++) {
                rotor1QueValues.add(rotor1QueValues.poll());

            }

        }

        temp.clear(); // deleting temporary list

        for (int x = 0; x < 95; x++) { // creating proper, rotated rotor as a BiMap

            rotor0.put(rotor1QueKeys.poll(), rotor1QueValues.poll());

        }

    }



    /**
     * Returns a value for a given key after proper rotor is constructed
     *
     * @param x
     *            key
     * @return value for a given key, after proper rotor is constructed
     */
    public String getCodeNormalRotor(String x) {
        return rotor0.get(x);
    }

    /**
     * Returns a key for a given value after proper rotor is constructed
     *
     * @param x
     *            value
     * @return key for a given value, after proper rotor is constructed
     */
    public String getCodeReverseRotor(String x) {

        return rotor0.inverse().get(x);
    }

}
