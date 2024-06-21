public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfiedCustomers = 0;

       
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfiedCustomers += customers[i];
            }
        }

       
        int additionalSatisfied = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
        }

       
        int maxAdditionalSatisfied = additionalSatisfied;
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                additionalSatisfied -= customers[i - minutes];
            }
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, additionalSatisfied);
        }

        return satisfiedCustomers + maxAdditionalSatisfied;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] customers1 = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy1 = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes1 = 3;
        System.out.println("Max Satisfied Customers: " + solution.maxSatisfied(customers1, grumpy1, minutes1)); // 

        // Test case 2
        int[] customers2 = {1};
        int[] grumpy2 = {0};
        int minutes2 = 1;
        System.out.println("Max Satisfied Customers: " + solution.maxSatisfied(customers2, grumpy2, minutes2)); // 
    }
}
