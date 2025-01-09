package exercise;

/**
 * @Author : Ze Li
 * @Date : 09/01/2025 16:30
 * @Version : V1.0
 * @Description :
 */
public class CorporateFlightBookings1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int []arr = new int[n + 1];
        for(int []r : bookings){
            arr[r[0] - 1] += r[2];
            arr[r[1]] -= r[2];
        }
        for(int i = 1; i <= n; i++)
            arr[i] += arr[i - 1];
        int []res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = arr[i];
        return res;
    }

//    public int[] corpFlightBookings(int[][] bookings, int n) {
//        int[] result = new int[n];
//        for (int[] booking : bookings){
//            for (int flight = booking[0]; flight <= booking[1]; flight++){
//                result[flight-1] += booking[2];
//            }
//        }
//        return result;
//    }
}
