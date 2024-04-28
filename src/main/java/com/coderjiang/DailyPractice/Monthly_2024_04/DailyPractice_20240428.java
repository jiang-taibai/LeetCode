package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-04-28 10:50:54</p>
 */
public class DailyPractice_20240428 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12371831};
        for (int number : numbers) {
            System.out.printf("%d(%s): %s\n", number, Integer.toBinaryString(number), solution.baseNeg2(number));
        }
    }

    static class Solution {

        private static final int MAX_BIT = 100;

        public String baseNeg2(int n) {
            if (n == 0) return "0";
            int[] bits = toBits(n);
            int[] addend1 = Arrays.copyOf(bits, bits.length);
            int[] addend2 = new int[bits.length];
//            System.out.println(Arrays.toString(addend1));
            for (int i = 0; i < bits.length - 1; i++) {
                if ((i & 1) == 0) {
                    // 偶数位，可能是2以上的数字，需要进位
                    if (addend1[i] > 1) {
                        addend1[i + 1] += addend1[i] / 2;
                        addend1[i] %= 2;
                    }
                } else {
                    // 奇数位，不能是1，所以需要进位
                    if (addend1[i] >= 1) {
                        if ((addend1[i] & 1) == 1) {
                            addend2[i] = 1;
                            addend1[i]++;
                        }
                        addend1[i + 1] += addend1[i] / 2;
                        addend1[i] = 0;
                    }
                }
            }
//            System.out.println(Arrays.toString(addend1));
            int[] res = addBits(addend1, addend2);
            StringBuilder sb = new StringBuilder();
            boolean start = false;
            for (int i = res.length - 1; i >= 0; i--) {
                if (res[i] == 1) start = true;
                if (start) {
                    sb.append(res[i]);
                }
            }
            return sb.toString();
        }

        private int[] toBits(int num) {
            int[] bits = new int[MAX_BIT];
            int base = 1;
            for (int i = 0; i < bits.length && num > 0; ++i) {
                if ((num & base) == base) {
                    bits[i] = 1;
                    num -= base;
                }
                base <<= 1;
            }
            return bits;
        }

        private int[] addBits(int[] bits1, int[] bits2) {
            if (bits1.length != bits2.length) return null;
            int[] added = new int[bits1.length];
            int carry = 0;
            for (int i = 0; i < bits1.length; i++) {
                added[i] = (bits1[i] + bits2[i] + carry) % 2;
                carry = (bits1[i] + bits2[i] + carry) / 2;
//                added[i] = bits1[i] + bits2[i];
            }
            return added;
        }
    }

}

/*
2= (4) - (2)
3= (1+4) - (2)
5 = (1+4)
6 = (16) - (2+8)
大致思路就是
num=addend1-addend2
addend1由2的偶数次幂组成
addend2由2的奇数次幂组成
已知num，可以推出addend1，再反推addend2
 */