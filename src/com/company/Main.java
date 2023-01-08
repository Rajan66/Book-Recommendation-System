package com.company;

import java.util.ArrayList;
import java.util.Scanner;


//TODO insertion and deletion feature
// TODO display the book count
public class Main {

    static ArrayList<Book> bookList;
    static int length;
    static Helper obj = new Helper();
    static Sort sorter = new Sort();
    static Search searcher = new Search();

    public static void main(String[] args) throws Exception {


        bookList = (ArrayList<Book>) obj.getList();
        obj.insert();
//        obj.display();
    }
}
