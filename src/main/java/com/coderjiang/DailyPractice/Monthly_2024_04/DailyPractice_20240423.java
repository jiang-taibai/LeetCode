package com.coderjiang.DailyPractice.Monthly_2024_04;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-04-23 09:11:47</p>
 */
public class DailyPractice_20240423 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int n = customers.length;
            int primitiveSatisfied = 0;
            for (int i = 0; i < n; i++) {
                if (grumpy[i] == 0) primitiveSatisfied += customers[i];
            }
            int additionalSatisfied = 0;
            int maxAdditionalSatisfied = 0;
            for (int i = 0; i < minutes; i++) {
                if (grumpy[i] == 1) additionalSatisfied += customers[i];
            }
            maxAdditionalSatisfied = additionalSatisfied;
            int lhs = 0, rhs = minutes - 1;
            while (rhs + 1 < n) {
                if (grumpy[lhs] == 1) additionalSatisfied -= customers[lhs];
                lhs++;
                rhs++;
                if (grumpy[rhs] == 1) additionalSatisfied += customers[rhs];
//                System.out.println("additionalSatisfied = " + additionalSatisfied);
                if (additionalSatisfied > maxAdditionalSatisfied) maxAdditionalSatisfied = additionalSatisfied;
            }
//            System.out.println("primitiveSatisfied = " + primitiveSatisfied);
//            System.out.println("maxAdditionalSatisfied = " + maxAdditionalSatisfied);
            return primitiveSatisfied + maxAdditionalSatisfied;
        }
    }

}
