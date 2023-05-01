package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Split the string into an array of words
        wordcounts("the quick brown fox jumps over the lazy dog");
        String fileName = "src/main/java/org/example/example.txt";
        List<String> lines = readLinesFromFile(fileName);
        String[] linesArray = lines.toArray(new String[0]);
        for (String line : linesArray) {
            wordcounts(line);
        }
    }

    private static List<String> readLinesFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void wordcounts(String string) {
        // Split the string into an array, each element is a word.
        String[] words = string.split("\\s+");
        //Store the word counts in a hash map, this way you can store the word as a key
        // and the count of the word as the value.
        Map<String, Integer> wordCounts = new HashMap<>();
        // Loop through each word in the array
        for (String word : words) {
            // If the word is not in the HashMap yet, add it with a count of 1
            if (!wordCounts.containsKey(word)) {
                wordCounts.put(word, 1);
            }
            // If the word is already in the HashMap, increment its count by 1
            else {
                wordCounts.put(word, wordCounts.get(word) + 1);
            }
        }
       //Because the problem just asked for printing the counts, that's all we are going to do today.
        for (String word : wordCounts.keySet()) {
            System.out.println(word + " " + wordCounts.get(word));
        }
    }





    }