package course;
/**
 * @Author : Ze Li
 * @Date : 19/10/2024 23:38
 * @Version : V1.0
 * @Description :
 */
public class firstcourse {
    public static void main(String[] args) {
        firstcourse firstcourse = new firstcourse();
        int[] arr = {5, 3, 8, 6, 2, 7, 1, 4, 9, 0,-1};
        firstcourse.bubbleSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }
    public void bubbleSort(int[] arr){
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

    public void QuickSort(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        if (left != right){
            int pivot = arr[left];
            for(int i = left + 1; i <= right; i++){
                if (arr[i] < pivot){
                    int temp = arr[i];
                    arr[i] = arr[left];
                    arr[left] = temp;
                    left++;
                }
                }
            }
        }
    }
}
