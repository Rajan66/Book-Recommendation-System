package com.company;

import javax.swing.border.Border;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class GoldenBoot {

    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();
        String line;
        int value = 0;
        try {
            FileReader fileReader = new FileReader("C:\\Users\\Radhika" +
                    "\\IdeaProjects\\Book Recommendation System\\Golden.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null) {
                String[] keyValuePair = line.split(" ");
                String key = keyValuePair[0];
                value += Integer.parseInt(keyValuePair[1]);
                data.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String player = " ";
        int goals = -1;
        for (String name : data.keySet()) {
            if (data.get(name) > goals) {
                player = name;
                goals = data.get(name);
            }
            System.out.println(name + ": " + data.get(name));
        }
        System.out.println(player + " won the Golden Boot with " + goals + " goals");
    }
}
