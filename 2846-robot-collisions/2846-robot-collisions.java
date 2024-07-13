import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = i;
        }
        
        Arrays.sort(robots, (a, b) -> a[0] - b[0]);
        
        Deque<int[]> stack = new ArrayDeque<>();
        List<int[]> survivingRobots = new ArrayList<>();
        
        for (int[] robot : robots) {
            int position = robot[0];
            int health = robot[1];
            int index = robot[2];
            char direction = directions.charAt(index);
            
            if (direction == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek()[1] < health) {
                    health--;
                    stack.pop();
                }
                
                if (!stack.isEmpty() && stack.peek()[1] == health) {
                    stack.pop();
                } else if (!stack.isEmpty() && stack.peek()[1] > health) {
                    int[] top = stack.pop();
                    top[1]--;
                    stack.push(top);
                } else {
                    survivingRobots.add(new int[] {position, health, index});
                }
            }
        }
        
        while (!stack.isEmpty()) {
            survivingRobots.add(stack.pop());
        }
        
        survivingRobots.sort((a, b) -> a[2] - b[2]);
        
        List<Integer> result = new ArrayList<>();
        for (int[] robot : survivingRobots) {
            result.add(robot[1]);
        }
        
        return result;
    }
}
