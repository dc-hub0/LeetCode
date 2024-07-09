public class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0;
        int currentTime = 0;
        
        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int preparationTime = customer[1];

            if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }

            totalWaitingTime += (currentTime + preparationTime - arrivalTime);
 
            currentTime += preparationTime;
        }
        
        return totalWaitingTime / customers.length;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] customers1 = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println(sol.averageWaitingTime(customers1)); 

        int[][] customers2 = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        System.out.println(sol.averageWaitingTime(customers2)); 
    }
}
