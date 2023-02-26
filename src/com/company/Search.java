package com.company;

import java.util.ArrayList;
import java.util.Scanner;
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
    public void run(){
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
