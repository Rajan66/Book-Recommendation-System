package com.company;


import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Convert {
    public static void main(String[] args) throws Exception{
//        ObjectMapper mapper = new ObjectMapper();
//        List<Book> books = mapper.readValue("books.json", new TypeReference<List<Book>>(){});
//        System.out.println(books.get(1).author);
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\Radhika\\IdeaProjects\\Book Recommendation System\\src\\com\\company\\books.json");
        Object obj = parser.parse(reader);

        List<JSONObject> jObject = (List<JSONObject>) obj;

        List<Book> books = new ArrayList<>();
        String author = (String) jObject.get(0).get("author");
        books.get(0).setAuthor(author);;
        System.out.println(books.get(0).author);
    }

}
