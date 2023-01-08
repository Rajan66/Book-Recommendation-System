package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import com.company.Main.*;
import org.json.JSONArray;

import static com.company.Main.*;

public class Helper {

    Scanner sc = new Scanner(System.in);
    ObjectMapper mapper = new ObjectMapper();

    public List<Book> getList() throws Exception {
        String jsonInput = FileUtils.readFileToString(new File("res\\books.json"), StandardCharsets.UTF_8);
        List<Book> book = mapper.readValue(jsonInput, new TypeReference<List<Book>>() {
        });

        return book;
    }

    public void insert() throws IOException {


        Book newBook = new Book();
        newBook = getObjectData(newBook);
        JSONArray list = new JSONArray();
        bookList.add(newBook);
        try {
            FileWriter fileWriter = new FileWriter("res\\books.json",true);         // writing back to the file

            String jsonStr = mapper.writeValueAsString(newBook);
            System.out.println(jsonStr);

            fileWriter.write(jsonStr);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  Book getObjectData(Book newBook) {

        System.out.println("Enter the details: ");

        System.out.print("Author: ");
        newBook.setAuthor(sc.nextLine());

        System.out.print("Title: ");
        newBook.setTitle(sc.nextLine());

        System.out.print("Genre: ");
        newBook.setGenre(sc.nextLine());

        System.out.print("Pages: ");
        newBook.setPages(sc.nextInt());
        //TODO check whether the input is int or not.
        System.out.print("Published Date: ");
        newBook.setYear(sc.nextInt());

        return newBook;
    }

    public void display() {
        System.out.println("Before Sorting: ");
        for (Book book : bookList) {
            System.out.println(book.getTitle());
        }

        sorter.sort(bookList);

        System.out.println("----------------------------------------");
        System.out.println("After sorting: ");
        for (Book book : bookList) {
            System.out.println(book.getAuthor());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a title to search: ");
        String input = scanner.nextLine().toLowerCase();

        int index = searcher.binarySearch(bookList, input.replaceAll("\\s+", ""));
        if (index == -1) {
            System.out.println(input + " not found!");
        } else {
            System.out.println("Details:- \nAuthor: " + bookList.get(index).getAuthor());
            System.out.println("Title: " + bookList.get(index).getTitle());
            System.out.println("Genre: " + bookList.get(index).getGenre());
            System.out.println("Pages: " + bookList.get(index).getPages());
            System.out.println("Published Date: " + bookList.get(index).getYear());
        }
    }
}
