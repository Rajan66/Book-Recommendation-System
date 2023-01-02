package com.company;

public class BinarySearch {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4, 5, 6, 7};
        int x = 5;
        int result = 0;
        int low = number[0], high = number[6];
        int mid = (low + high) / 2;

        while (low <= high) {
            if (x == mid)
                System.out.println(mid);

            // If x greater, ignore left half
            if (mid > x)
                low = mid + 1;

                // If x is smaller, ignore right half
            else
                high = mid - 1;
        }
    }
}
