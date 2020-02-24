package sort;

import java.util.Arrays;

public class BubbleSort {

        int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        int temp = 0;

        private void BubbleSortMethod() {

            for(int i=1; i <= array.length; i++){
                for(int j=0; j < array.length - i; j++){
                    if(array[j] > array[j+1]) {
                        temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }

            System.out.println("값 : " + Arrays.toString(array));
        }

        private void BubbleSortMethod2() {
            for(int i=0; i < array.length; i++) {
                int charge = 0;
                for(int j = array.length-1; i < j; j--) {
                    if(array[j-1] > array[j]){
                        swap(array,j-1,j);
                        charge++;
                    }
                }
                if(charge == 0) break;
            }
            System.out.println("값 : " + Arrays.toString(array));
        }

        private void swap(int[] array, int a, int b) {
            temp = array[b];
            array[b] = array[a];
            array[a] = temp;
        }

    public static void main(String[] args) {
        BubbleSort bubble = new BubbleSort();
        //bubble.BubbleSortMethod();
        bubble.BubbleSortMethod2();
    }
}
