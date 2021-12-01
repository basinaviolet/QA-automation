package com.it_academy.practice.junit_basics;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommonLang {

    public static void createLang() {
        int numberOfWords = 10;
        List<String> randomWordList = new ArrayList<>();
        List<String> createWordList = new ArrayList<>();

        // creating list from random words
        for (int i = 0; i < numberOfWords; i++) {
            randomWordList.add(createStr());
        }
        System.out.println(randomWordList.toString());

        // changing the first letter to upper case and all other letters to lower one
        for (String s: randomWordList) {
            createWordList.add(StringUtils.upperCase(StringUtils.substring(s, 0,1))+StringUtils.lowerCase(StringUtils.substring(s,1)));
        }

        System.out.println(createWordList.toString());
    }

    // creating random word
    public static String createStr() {
        Random r = new Random();
        int numberOfChars = r.nextInt(10) + 2;
        char[] randomCharArray = new char[numberOfChars];
        int check;

        for (int i = 0; i < numberOfChars; i++) {
            check = r.nextInt(57) + 65;
            while ((check >= 91) && (check <= 96)) {
                check = r.nextInt(57) + 65;
            }
            randomCharArray[i] = (char) check;
        }
        return StringUtils.join(randomCharArray, ',').replace(",", "");
    }
}
