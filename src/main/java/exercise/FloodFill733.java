package exercise;

/**
 * @Author : Ze Li
 * @Date : 13/03/2025 13:49
 * @Version : V1.0
 * @Description :
 */
public class FloodFill733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color){return image;}
        floodFill(image, sr, sc, color, originalColor);
        return image;
    }

    public void floodFill(int[][] image, int sr, int sc, int color, int originalColor) {
        if (image[sr][sc] != originalColor){
            return;
        }
        image[sr][sc] = color;
        if (sr > 0){
            floodFill(image, sr-1, sc, color, originalColor);
        }
        if (sr < image.length-1){
            floodFill(image, sr+1, sc, color, originalColor);
        }
        if (sc > 0){
            floodFill(image, sr, sc-1, color, originalColor);
        }
        if (sc < image[0].length-1){
            floodFill(image, sr, sc+1, color, originalColor);
        }
    }
}
