package sort;

import java.util.Arrays;

public class QuickSort {

    int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
    int temp = 0;


    public void quickSortMethod(int[] array,int left,int right) {

        int pl = left;
        int pr = right;
        int x = array[(pl+pr) / 2];

        do{
            while (array[pl] < x) pl++;
            while (array[pr] > x) pr--;
            if (pl <= pr)
            swap(array,pl++,pr--);
        } while (pl <= pr);

        //System.out.println("값 : " + Arrays.toString(array));
        if (left < pr) quickSortMethod(array,left,pr);
        if (pl < right) quickSortMethod(array,pl,right);
    }

    // 배열값 위치 변경
    private void swap(int[] array, int a, int b) {
        temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSortMethod(quickSort.array,0,quickSort.array.length - 1);

        System.out.println("값 : " + Arrays.toString(quickSort.array));
    }
}
