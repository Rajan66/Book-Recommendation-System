package com.company;

import java.util.ArrayList;

public class Main {

    static ArrayList<Book> bookList;
    static int length;
    static Helper helperObj = new Helper();
    static Sort sortObj = new Sort();
    static Search searchObj = new Search();
    static MenuFrame menuFrame;

    public static void main(String[] args) throws Exception {
        bookList = (ArrayList<Book>) helperObj.getList();

        menuFrame = new MenuFrame();
        menuFrame.run();
    }
}
