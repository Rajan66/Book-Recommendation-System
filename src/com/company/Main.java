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
    static Scanner sc = new Scanner(System.in);
    static MenuFrame menuFrame;

    public static void main(String[] args) throws Exception {


        bookList = (ArrayList<Book>) obj.getList();
        menuFrame = new MenuFrame();
        menuFrame.run();
//        obj.insert();
        sorter.sort(bookList);
        obj.display();
//        searcher.run();

    }
}
