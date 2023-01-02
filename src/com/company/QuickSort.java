package com.company;

import java.util.*;

public class QuickSort {

    static ArrayList<String> books;
    int length;

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        List<String> list = Arrays.asList("Pride and","It Ends with Us",
                "The Great Gatsby", "To Kill a Mockingbird","The Zahir", "The Kite Runner","Bahir");
//        List<String> list = Arrays.asList("ram", "ashmita",
//                "lumana", "zahir", "bikash", "anita");
        // works for list without spaces

        ArrayList<String> book_list = new ArrayList<>(list); // the strings need to be sorted are put inside this array
        sorter.sort(book_list);

        for (String i : books) {
            System.out.print(i);
            System.out.print(" ");
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

    void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;

        String pivot = books.get(lowerIndex + (higherIndex - lowerIndex) / 2).replaceAll("\\s+","");


        while (i <= j) {

            while (books.get(i).replaceAll("\\s+","").compareToIgnoreCase(pivot) < 0) {
//                System.out.println(book_i);
                i++;

            }

            while (books.get(j).replaceAll("\\s+","").compareToIgnoreCase(pivot) > 0) {
//                System.out.println(book_j);
                j--;

            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        //call quickSort recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    void swap(int i, int j) {
        String temp = books.get(i);
        books.set(i,books.get(j));
        books.set(j,temp);
    }
}