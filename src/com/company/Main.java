package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.company.Converter;

public class Main {
    //TODO insertion and deletion feature
    // TODO display the book count

    public static void main(String[] args) throws Exception {
        List<Book> books = Converter.fromJsonString("books.json");
        System.out.println(books.get(1).author);
//        List<String> list = Arrays.asList( "It Ends with Us", "Pride and",
//                "The Great Gatsby","The Kite Runner","The Zahir", "To Kill a Mockingbird");
//
//        ArrayList<String> booksList = new ArrayList<>(list);

//        String[] books = {"It Ends with Us", "The Zahir", "To Kill a Mockingbird",
//                "The Great Gatsby", "Pride and", "The Kite Runner"};

//        String x = "It Ends with Us"; //String with spaces gives error
//        x = x.replaceAll("\\s+", "");
//        int result = binarySearch(booksList, x);
//
//        if (result == -1)
//            System.out.println("Element not present");
//        else
//            System.out.println("Element found at "
//                    + "index " + result);
    }
    //TODO implement a sorting algorithm(quick sort)


    static int binarySearch(ArrayList<String> arr, String x) {
        int low = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            int mid =  (high + low) / 2;
            String book = arr.get(mid).replaceAll("\\s+","");
            int result = x.compareTo(book);

            // Check if x is present at mid
            if (result == 0)
                return mid;

            // If x greater, ignore left half
            if (result > 0)
                low = mid + 1;

                // If x is smaller, ignore right half
            else
                high = mid - 1;
        }
        return -1;
    }


}
