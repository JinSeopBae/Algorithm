package sort;

import java.util.Arrays;

public class SelectionSort {

    public static void selectSort1() {
        int changeIndex = 0;
        int temp = 0;

        //int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        int array[] = {7,9,1,5,4};
        for(int i = 0; i < array.length; i++){
            int min = 9999;
            for(int j = i; j < array.length; j++){
                if(min > array[j]){
                    min = array[j];
                    changeIndex = j;
                }
            }

            temp = array[i];
            array[i] = array[changeIndex];
            array[changeIndex] = temp;
        }

        System.out.println("값 : " + Arrays.toString(array));

//        for (int i = 0; i < array.length; i++) {
//            int min = i; // 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 기록합니다. for(intj=i+1;j <n;j++)
//            for (int j = i; j < array.length; j++) {
//                if (array[j] < array[min]){
//                    min = j;
//                    changeIndex = j;
//                }
//
//                // 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환합니다.
//            }
//
//            temp = array[i];
//            array[i] = array[changeIndex];
//            array[changeIndex] = temp;
//        }
//        System.out.println("값 : " + Arrays.toString(array));
    }


    public static void main(String[] args) {
        selectSort1();
    }
}
