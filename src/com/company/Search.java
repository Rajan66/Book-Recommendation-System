package com.company;

import java.util.ArrayList;

public class Search {

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
}
