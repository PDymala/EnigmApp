package com.example.enigmapp;


import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class AsciiGenerator {

    private BiMap<String, String> asciiMap = HashBiMap.create();

    public AsciiGenerator() {



        for(int x = 32;  x < 127; x++){

            String str = Character.toString((char) x);
            asciiMap.put(str, Integer.toString(x));
        }



    }

    public String getAsciiCode(String value) {

        return asciiMap.get(value);
    }

    public String getSymbolFromAscii(String value) {
        return asciiMap.inverse().get(value);
    }

}
