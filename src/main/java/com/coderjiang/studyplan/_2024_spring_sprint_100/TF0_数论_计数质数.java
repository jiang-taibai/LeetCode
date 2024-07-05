package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-05 15:04:37</p>
 */
public class TF0_数论_计数质数 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int countPrimes(int n) {
            if (n <= 1) return 0;
            boolean[] prime = new boolean[n];
            Arrays.fill(prime, true);
            prime[0] = prime[1] = false;
            int res = 0;
            for (int i = 2; i < n; i++) {
                if (prime[i]) {
                    res++;
                    for (int j = i + i; j < n; j += i) {
                        prime[j] = false;
                    }
                }
            }
            return res;
        }
    }

    static class Solution2 {
        public int countPrimes(int n) {
            boolean[] prime = new boolean[n];
            Arrays.fill(prime, true);
            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i < n; i++) {
                if (prime[i]) primes.add(i);
                for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                    prime[i * primes.get(j)] = false;
                    if (i % primes.get(j) == 0) break;
                }
            }
            return primes.size();
        }
    }

}
