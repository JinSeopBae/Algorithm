package search;

import java.util.Arrays;

public class BinarySearch {

    private static int BinarySearchMethod(int[] array, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl+pr) / 2;
            if(array[pc] == key)
                return pc;
            else if(array[pc] < key)
                pl = pc + 1;
            else if(array[pc] > key)
                pr = pc - 1;
        } while (pl <= pr);
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,7,9,11,13,15,17,19};
        int result = BinarySearchMethod(array, array.length, 1);
        System.out.println(result);
    }
}
