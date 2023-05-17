package com.Convert_measurements.Convert_measurements;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] alphabet = "_abcdefghijklmnopqrstuvwxyz".toCharArray();
        Map<Character, Integer> letterNumberMap = new HashMap<>();

        for (int i = 0; i < alphabet.length; i++) {
            char letter = alphabet[i];
            int number = i;
            letterNumberMap.put(letter, number);
        }

        System.out.print("Enter a word: ");
        String inputWord = scanner.next().toLowerCase();

        StringBuilder extractedWord = new StringBuilder();

        while (inputWord.length() > 1) {
            char firstLetter = inputWord.charAt(0);
            int number = letterNumberMap.getOrDefault(firstLetter, -1);

            if (number != -1) {
                if (inputWord.length() > 1 && inputWord.length() >= number + 1) {
                    String subWord = inputWord.substring(1, number + 1);
                    extractedWord.append(subWord).append("");
                    inputWord = inputWord.substring(number + 1);

                    int countZ=0;
                    for(int i = 1; i <= subWord.length(); i++){
                        if(inputWord.charAt(i) == 'z'){
                            countZ++;
                        }
                    }
                    if (subWord.contains("z")) {
                        if (inputWord.length() > 0) {
                            extractedWord.append(inputWord.charAt(0)).append("");
                            inputWord = inputWord.substring(countZ);
                        }
                    }
                    extractedWord.append(" ");
                } else {
                    extractedWord.append(inputWord);
                    inputWord = "";
                }
            } else {
                inputWord = inputWord.substring(0);
            }
        }

        System.out.println("Extracted Subwords: " + extractedWord);
    }
}
