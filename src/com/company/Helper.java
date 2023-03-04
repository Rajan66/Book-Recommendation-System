package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Helper {

    ObjectMapper mapper = new ObjectMapper();
    static List<Book> book;

    public List<Book> getList() throws Exception {
        String jsonInput = FileUtils.readFileToString(new File("res\\books.json"), StandardCharsets.UTF_8);
        book = mapper.readValue(jsonInput, new TypeReference<List<Book>>() {
        });
        return book;
    }
}
