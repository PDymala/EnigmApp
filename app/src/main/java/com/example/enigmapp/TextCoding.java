package com.example.enigmapp;

import android.util.Log;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TextCoding {

    private String inputFile;
    private String outputFile;

    private Queue<String> rotor1QueKeys = new LinkedList<String>();
    private Queue<String> rotor1QueValues = new LinkedList<String>();
    private List<String> temp = new ArrayList<String>();
    private String initialCode;
    private int rotorNumber;
    private int characterNumber = 0;

    //  String rotorInput = "enigma95_rew.tsv";
    String inputText = "";
    String outputText = "";

    /**
     * This class creates coded text based on given string.
     *
     * @param inputText
     *            String (text) to code
     * @param secretCode
     *            String (text) secret code to code and decode given text. Has to
     *            have 4 characters.
     */

    public TextCoding(String inputText, String secretCode) {
        this.inputText = inputText;


        AsciiGenerator ascii = new AsciiGenerator();
        // temporary array that splits text into chars
        String[] ary = inputText.split("");

        // for each symbol it does the given function
        for (int x = 0; x < ary.length; x++) {

            char character = ary[x].charAt(0);
            int c = (int) character;
            characterNumber = x;
            // only possible to code writable ASCII symbols
            if (c > 31 && c < 127) {

                // the function mixes given character 3 times on dynamic rotor, once on a mirror
                // rotor and 3 times on reversed dynamic rotor

                String tempCharacter = "";
                Rotor rotor1 = new Rotor(ascii.getAsciiCode(Character.toString(secretCode.charAt(0))), 1,
                        characterNumber);
                tempCharacter = ascii.getSymbolFromAscii(
                        rotor1.getCodeNormalRotor(ascii.getAsciiCode(Character.toString(character))));

                Rotor rotor2 = new Rotor(ascii.getAsciiCode(Character.toString(secretCode.charAt(1))), 2,
                        characterNumber);
                String tempCharacter2 = ascii
                        .getSymbolFromAscii(rotor2.getCodeNormalRotor(ascii.getAsciiCode(tempCharacter)));

                Rotor rotor3 = new Rotor(ascii.getAsciiCode(Character.toString(secretCode.charAt(2))), 3,
                        characterNumber);
                String tempCharacter3 = ascii
                        .getSymbolFromAscii(rotor3.getCodeNormalRotor(ascii.getAsciiCode(tempCharacter2)));

                Rotor rotor4 = new Rotor(ascii.getAsciiCode(Character.toString(secretCode.charAt(3))), 4,
                        characterNumber);
                String tempCharacter4 = ascii
                        .getSymbolFromAscii(rotor4.getCodeNormalRotor(ascii.getAsciiCode(tempCharacter3)));

                Rotor rotor5 = new Rotor(ascii.getAsciiCode(Character.toString(secretCode.charAt(2))), 3,
                        characterNumber);
                String tempCharacter5 = ascii
                        .getSymbolFromAscii(rotor5.getCodeReverseRotor(ascii.getAsciiCode(tempCharacter4)));

                Rotor rotor6 = new Rotor(ascii.getAsciiCode(Character.toString(secretCode.charAt(1))), 2,
                        characterNumber);
                String tempCharacter6 = ascii
                        .getSymbolFromAscii(rotor6.getCodeReverseRotor(ascii.getAsciiCode(tempCharacter5)));

                Rotor rotor7 = new Rotor(ascii.getAsciiCode(Character.toString(secretCode.charAt(0))), 1,
                        characterNumber);
                String tempCharacter7 = ascii
                        .getSymbolFromAscii(rotor7.getCodeReverseRotor(ascii.getAsciiCode(tempCharacter6)));

                outputText += tempCharacter7;

            }

        }
    }

    public String getOutputText() {
        return outputText;
    }

}
