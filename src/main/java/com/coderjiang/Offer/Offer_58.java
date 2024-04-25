package com.coderjiang.Offer;

/**
 * <p>Creation Time: 2021-12-15 19:46:48</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_58 {

    static class Solution {
        public String reverseWords(String s) {
            if (s.equals("")) return s;
            char[] chars = s.trim().toCharArray();
            char[] res = new char[chars.length + 1];
            int head = chars.length - 1, tail = chars.length - 1;
            int index = 0;
            while (tail >= 0) {
                while (head >= 0 && chars[head] != ' ') head--;
                for (int i = head + 1; i <= tail; ++i) {
                    res[index++] = chars[i];
                }
                res[index++] = ' ';
                while (head >= 0 && chars[head] == ' ') head--;
                tail = head;
            }
            return String.valueOf(res, 0, index - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue") + "##");
    }

}
