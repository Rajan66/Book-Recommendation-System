package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    static ArrayList<String> books;
    int length;

    public static void main(String[] args) {
        Sort sorter = new Sort();
//        List<String> list = Arrays.asList("It Ends with Us", "Pride and",
//                "The Great Gatsby", "The Kite Runner", "The Zahir", "To Kill a Mockingbird");
        List<String> list = Arrays.asList("AE", "AC",
                "AM", "BAW", "BEW", "BAE");

        ArrayList<String> book_list = new ArrayList<>(list); // the strings need to be sorted are put inside this array
        sorter.sort(book_list);

        for (String i : books) {
            System.out.println(i);

        }
    }
    void sort(ArrayList<String> array) {
        if (array == null || array.size() == 0) {
            return;
        }
        books = array;
        this.length = array.size();
        quickSort(0, length - 1);
    }

    public void quickSort(int start, int end) {

        int i = start;

        int j = end;


        if (j - i >= 1)
        {

            String pivot = books.get(i).replaceAll("\\s+","");

            String book_i = books.get(i).replaceAll("\\s+", "");
            String book_j = books.get(j).replaceAll("\\s+", "");

            while (j > i)
            {

                while (book_i.compareTo(pivot)  <= 0 && i < end && j > i){
                    book_i = books.get(i).replaceAll("\\s+", "");
                    i++;
                }

                while (book_j.compareTo(pivot) >= 0 && j > start && j >= i){
                    book_j = books.get(j).replaceAll("\\s+", "");

                    j--;
                }

                if (j > i)
                    swap( i, j);
            }
//TODO hmm not getting trimmed or smth idk whats happening yetae katae problem xa
            swap(start, j);

            quickSort(start, j - 1);

            quickSort(j + 1, end);
        }
    }
    void swap(int i, int j) {
//        System.out.println("book_i : " + books.get(i));
//        System.out.println("book_j : " + books.get(j));
        String temp = books.get(i);
        books.set(i,books.get(j));
        books.set(j,temp);
//        System.out.println("book_i : " + books.get(i));
//        System.out.println("book_j : " + books.get(j));
    }
}
