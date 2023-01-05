package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GetList {


    public List<Book> getList() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        String jsonInput = FileUtils.readFileToString(new File("C:\\Users\\Radhika\\IdeaProjects\\Book Recommendation System\\res\\books.json"), StandardCharsets.UTF_8);
        List<Book> book = mapper.readValue(jsonInput, new TypeReference<List<Book>>(){});

        return book;
    }
}
