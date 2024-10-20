package course;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 19/10/2024 23:38
 * @Version : V1.0
 * @Description :
 */
public class FirstCourse {
    public static void main(String[] args) {
        FirstCourse firstCourse = new FirstCourse();
        int[] arr = {5, 3, 8, 6, 2, 7, 1, 4, 9, 0,-1};
        firstCourse.bubbleSort(arr);
        for (int k : arr) {
            System.out.print(k + " ");
        }
        firstCourse.quickSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
        firstCourse.mergeSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public void bubbleSort(int[] arr){
        System.out.println();
        System.out.println("BubbleSort");
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public void quickSort(int[] arr){
        System.out.println();
        System.out.println("QuickSort");
        if (arr.length <= 1){
            return;
        }else{
            quickSort(arr, 0, arr.length - 1);
        }
    }

    public void quickSort(int[] arr, int left, int right){
        if (left >= right) {
            return;
        }
        int pivot = arr[left];
        int j = left;
        for (int i = left+1; i <= right; i++) {
            if (arr[i] < pivot) {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = pivot;
        arr[left] = temp;
        quickSort(arr, left, j - 1);
        quickSort(arr, j + 1, right);
    }

    public void mergeSort(int[] arr){
        System.out.println();
        System.out.println("MergeSort");
        mergeSort(arr, 0, arr.length - 1);
    }
    public void mergeSort(int[] arr, int left, int right){
         if (left < right) {
             int middle = (left + right) / 2;
             mergeSort(arr, left, middle);
             mergeSort(arr, middle + 1, right);

             int[] left_arr = Arrays.copyOfRange(arr, left, middle + 1);
             int[] right_arr = Arrays.copyOfRange(arr, middle + 1, right + 1);
             int j = 0; int k = 0;
             int i;
             for (i = left; i < right+1; i++) {
                 if (left_arr[j] < right_arr[k]){
                     arr[i] = left_arr[j];
                     j++;
                     if (j == left_arr.length){
                         while (k < right_arr.length){
                             i++;
                             arr[i] = right_arr[k];
                             k++;
                         }
                         return;
                     }
                 }else{
                     arr[i] = right_arr[k];
                     k++;
                     if (k == right_arr.length){
                         while (j < left_arr.length){
                             i++;
                             arr[i] = left_arr[j];
                             j++;
                         }
                         return;
                     }
                 }
             }
         }
    }
}
