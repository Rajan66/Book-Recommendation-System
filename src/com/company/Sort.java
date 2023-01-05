package com.company;

import java.util.ArrayList;
import static com.company.Main.*;

public class Sort {
    public void sort(ArrayList<Book> books) {
        if (books == null || books.size() == 0) {
            return;
        }
        bookList = books;
        length = books.size();
        quickSort(0, length - 1);
    }

    public void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;

        String pivot = bookList.get(lowerIndex + (higherIndex - lowerIndex) / 2).getTitle().replaceAll("\\s+", "");

        while (i <= j) {

            while (bookList.get(i).getTitle().replaceAll("\\s+", "").compareToIgnoreCase(pivot) < 0) {
                i++;

            }

            while (bookList.get(j).getTitle().replaceAll("\\s+", "").compareToIgnoreCase(pivot) > 0) {
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

    public void swap(int i, int j) {
        Book temp = bookList.get(i);
        bookList.set(i, bookList.get(j));
        bookList.set(j, temp);
    }
}
