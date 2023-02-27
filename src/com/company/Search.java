package com.company;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Helper.book;
import static com.company.Main.bookList;
import static com.company.Main.searcher;

public class Search {
    Scanner sc = new Scanner(System.in);

    public int binarySearch(ArrayList<Book> data, String x) {
        int low = 0;
        int high = data.size() - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            String book = data.get(mid).getTitle().replaceAll("\\s+", "");
            int result = x.compareTo(book.toLowerCase());
            if (result == 0)
                return mid;
            if (result > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public void run() {
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

    public void delete() throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a title to delete: ");
        String input = scanner.nextLine().toLowerCase();

        int index = searcher.binarySearch(bookList, input.replaceAll("\\s+", ""));
        if (index == -1) {
            System.out.println(input + " not found!");
        } else {
            try {
                JSONArray jsArray = new JSONArray();
                for (Book item : bookList) {
                    jsArray.put(item);
                }
                FileWriter fileWriter = new FileWriter("res\\books.json");

//                Book obj = (Book) jsArray.get(index);
//                System.out.println(obj.getAuthor());
                book.remove(index);
                jsArray = new JSONArray(book);

                fileWriter.write(jsArray.toString());
                fileWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
