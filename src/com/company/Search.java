package com.company;

import java.util.ArrayList;

public class Search {
    public int binarySearch(ArrayList<String> arr, String x) {
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
