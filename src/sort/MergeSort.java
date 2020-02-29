package sort;

import java.util.Arrays;

public class MergeSort {
    int[] buff = new int[10];


    private void MergeSortMethod(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p=0;
            int j=0;
            int k=left;
            // 재귀 함수 왼쪽 정렬
            MergeSortMethod(a, left, center);
            // 재귀 함수 오른쪽 정렬
            MergeSortMethod(a, center + 1, right);

            for (i = left; i <= center; i++) buff[p++] = a[i];
            while (i <= right && j < p)
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
            while (j < p)
                a[k++] = buff[j++];
        }

    }

    private void MerSortMethod2(int[] a, int m, int middle, int n) {
        int i = m;
        int j = middle + 1;
        int k = m;
        while(i <= middle && j <= n) {
            if(a[i] <= a[j]) {
                buff[k] = a[i];
                i++;
            } else {
                buff[k] = a[j];
                j++;
            }
            k++;
        }

        if (i > middle) {
            for(int t = j; t <= n; t++) {
                buff[k] = a[t];
                k++;
            }
        } else {
            for(int t = i; t<= middle; t++){
                buff[k] = a[t];
                k++;
            }
        }

        for (int t = m; t <= n; t++){
            a[t] = buff[t];
        }

        System.out.println("값 : " + Arrays.toString(a));
    }

    private void MergeSort(int[] a, int m, int n) {
        if(m < n) {
            int middle = (m+n) / 2;
            MergeSort(a,m,middle);
            MergeSort(a,middle+1,n);
            MerSortMethod2(a,m,middle,n);
        }
        System.out.println("값 : " + Arrays.toString(a));
    }

    private void MergeSort(int[] a) {
        buff = new int[a.length];
        MergeSortMethod(a, 0, a.length-1);
        System.out.println("값 : " + Arrays.toString(a));
        // 정렬이 끝나면 안쓰는 배열 객체 (메모리 낭비)
        buff = null;
    }

    public static void main(String[] args) {
        int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        MergeSort merge = new MergeSort();
        //merge.MergeSort(array);
        merge.MergeSort(array,0,array.length -1);
    }
}
