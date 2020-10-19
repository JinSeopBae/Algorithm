package sort;

import java.util.Arrays;

public class HeapSort {

    static int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

    public void heapArray(int[] a, int left, int right) {
        int temp = array[left];
        int child;
        int parent;

        for(parent = left; parent < (right+1) / 2; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
            if(temp >= a[child])
                break;
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    public void heapSortMethod(int[] a) {
        for(int i = (a.length-1) / 2; i>=0; i--)
            heapArray(a,i,a.length-1);

        for(int i = a.length -1; i >0; i--){
            swap(a,0,i);
            heapArray(a,0,i-1);
        }
    }


    private void swap(int[] array, int a, int b) {
        int temp;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        HeapSort heap = new HeapSort();
        heap.heapSortMethod(array);

        System.out.println("값 : " + Arrays.toString(array));
    }
}
