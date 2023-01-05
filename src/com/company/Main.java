package com.company;

import java.util.ArrayList;


//TODO insertion and deletion feature
// TODO display the book count
public class Main{
    static ArrayList<Book> bookList;
    static int length;

    ArrayList<Book> bookArrayList = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        GetList obj = new GetList();
        Sort sorter = new Sort();
        Search searcher = new Search();

        bookList = (ArrayList<Book>) obj.getList();
        System.out.println("Before Sorting: ");
        for(Book book: bookList){
            System.out.println(book.getTitle());
        }

        sorter.sort(bookList);
        System.out.println("----------------------------------------");
        System.out.println("After sorting: ");
        for(Book book: bookList){
            System.out.println(book.getAuthor());
        }
    }
}
