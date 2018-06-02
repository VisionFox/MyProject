package com.offer;

public class No_1 {
    public static void main(String[] args) {
        int[][] array ={{1, 2, 8, 9},{2, 4, 9, 12},{4, 7, 10, 13},{6, 8, 11, 15}};
        System.out.println(find(5,array));
    }

    public static boolean find(int target, int[][] array) {
        if (array == null || array[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = array[0].length - 1;

        while (row < array.length || col >= 0) {
            if (target > array[row][col]) {
                row++;
            } else if (target < array[row][col]) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
