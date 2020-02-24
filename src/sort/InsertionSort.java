package sort;

import java.util.Arrays;

public class InsertionSort {

    int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
    int temp = 0;
    int j = 0;

    private void InsertionSortMethod() {
        for(int i=0; i < array.length -1; i++){
            j = i;
            while (array[j] > array[j+1]) {
                swap(array, j, j+1);
                j--;
            }
        }

        System.out.println("값 : " + Arrays.toString(array));
    }

    private void swap(int[] array, int a, int b) {
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        InsertionSort insertion = new InsertionSort();
        insertion.InsertionSortMethod();
    }
}
