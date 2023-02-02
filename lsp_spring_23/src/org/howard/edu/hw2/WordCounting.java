package org.howard.edu.hw2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounting {

	public static void main(String[] args) {
		//file path takes in the name of the text file to be read
        String filePath = "text.txt";
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        List<String> words = new ArrayList<String>();

        try {
            FileReader fileReader = new FileReader(filePath);

            // Create a BufferedReader object
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read the contents of the file
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // splitting the line into words
                String[] wordsInLine = line.split(" ");
                // add the words to the list
                for (String word : wordsInLine) {
                	//checking if the word is a number eg. 100 , it should be ignored
                	if (!isInteger(word)) {
                		 words.add(word);
                	}
                }
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        
        System.out.println(wordCount);
        

	}
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
	        return true;
		}
		catch(NumberFormatException e) {
			return false;
			
		}
	}

}
