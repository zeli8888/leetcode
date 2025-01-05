package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author : Ze Li
 * @Date : 05/01/2025 15:46
 * @Version : V1.0
 * @Description :
 */
public class WalkingRobotSimulation874 {
    public static void main(String[] args) {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        WalkingRobotSimulation874 walkingRobotSimulation874 = new WalkingRobotSimulation874();
        System.out.println(walkingRobotSimulation874.robotSim(commands, obstacles));
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // North, East, South, West
        int x = 0, y = 0, direction = 0, maxDistance = 0;

        for (int command : commands) {
            if (command == -1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int newX = x + directions[direction][0];
                    int newY = y + directions[direction][1];
                    if (!obstacleSet.contains(newX + "," + newY)) {
                        x = newX;
                        y = newY;
                        maxDistance = Math.max(maxDistance, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }

        return maxDistance;
    }

//    public int robotSim(int[] commands, int[][] obstacles) {
//        int[] pos = {0, 0};
//        HashSet<String> obstaclesSet = new HashSet<>();
//        for (int[] obstacle : obstacles){
//            String ob = obstacle[0] + ":" + obstacle[1];
//            obstaclesSet.add(ob);
//        }
//
//        int largestDis = 0;
//        int direction = 0;
//        for(int command : commands){
//            if (command == -1){
//                direction++;
//                direction %= 4;
//            } else if (command == -2) {
//                direction--;
//                direction %= 4;
//            }else {
//                if (direction == 0){
//                    int step;
//                    for (step = 0; step < command; step++){
//                        largestDis = (int) Math.max(largestDis, Math.pow(pos[0], 2) + Math.pow((pos[1]+step), 2));
//                        if (obstaclesSet.contains(pos[0] + ":" + (pos[1] + step + 1))){
//                            break;
//                        }
//                    }
//                    pos[1] += step;
//                } else if (direction == 1 || direction == -3) {
//                    int step;
//                    for (step = 0; step < command; step++){
//                        largestDis = (int) Math.max(largestDis, Math.pow(pos[1], 2) + Math.pow((pos[0]+step), 2));
//                        if (obstaclesSet.contains((pos[0] + step + 1) + ":" + pos[1])){
//                            break;
//                        }
//                    }
//                    pos[0] += step;
//                } else if (direction == 2 || direction == -2) {
//                    int step;
//                    for (step = 0; step < command; step++){
//                        largestDis = (int) Math.max(largestDis, Math.pow(pos[0], 2) + Math.pow((pos[1]-step), 2));
//                        if (obstaclesSet.contains(pos[0] + ":" + (pos[1] - step - 1))){
//                            break;
//                        }
//                    }
//                    pos[1] -= step;
//                } else if (direction == 3 || direction == -1) {
//                    int step;
//                    for (step = 0; step < command; step++){
//                        largestDis = (int) Math.max(largestDis, Math.pow(pos[1], 2) + Math.pow((pos[0]-step), 2));
//                        if (obstaclesSet.contains((pos[0] - step - 1) + ":" + pos[1])){
//                            break;
//                        }
//                    }
//                    pos[0] -= step;
//                }
//            }
//        }
//        return (int) Math.max(largestDis, Math.pow(pos[1], 2) + Math.pow(pos[0], 2));
//    }
}
