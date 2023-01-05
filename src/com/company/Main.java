package com.company;

import java.util.ArrayList;
import java.util.Scanner;


//TODO insertion and deletion feature
// TODO display the book count
public class Main {
    static ArrayList<Book> bookList;
    static int length;

    ArrayList<Book> bookArrayList = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        GetList obj = new GetList();
        Sort sorter = new Sort();
        Search searcher = new Search();

        bookList = (ArrayList<Book>) obj.getList();
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

        int index = searcher.binarySearch(bookList,input.replaceAll("\\s+",""));
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
