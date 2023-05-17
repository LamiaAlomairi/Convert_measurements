package com.Convert_measurements.Convert_measurements;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] alphabet = "_abcdefghijklmnopqrstuvwxyz".toCharArray();
        Map<Character, Integer> letterNumberMap = new HashMap<>();

        for (int i = 0; i < alphabet.length; i++){
            char letter = alphabet[i];
            int number = i;
            letterNumberMap.put(letter, number);
        }

        System.out.print("Enter a word: ");
        String inputWord = scanner.next().toLowerCase();

        StringBuilder extractedWord = new StringBuilder();

        boolean isZHandled = false; // Flag to track if 'z' has been handled as a special case

        while (inputWord.length() > 1){
            char firstLetter = inputWord.charAt(0);
            int number = letterNumberMap.getOrDefault(firstLetter, -1);

            if(number != -1){
                if(inputWord.length() > 1 && inputWord.length() >= number+1){
                        String subWord = inputWord.substring(1, number + 1);
                        extractedWord.append(subWord).append(" ");
                        inputWord = inputWord.substring(number + 1);
                }
                else{
                    //extractedWord.append(inputWord);
                    extractedWord.append(0);
                    inputWord = "";
                }
            }
            else{
                inputWord = inputWord.substring(1);
            }
        }
        /*System.out.println(inputWord.substring(0+1,0+2));
        for (int i = 0; i<inputWord.length(); i++){
            int val = letterNumberMap.get(inputWord.charAt(i));
            extractedWord.append(inputWord.substring(i+1,i+val+1));
            i = i+val;
        }*/

        System.out.println("Extracted Subwords: " + extractedWord);
    }
}
