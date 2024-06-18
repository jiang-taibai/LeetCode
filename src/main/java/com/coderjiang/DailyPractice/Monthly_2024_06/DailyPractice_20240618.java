package com.coderjiang.DailyPractice.Monthly_2024_06;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-18 19:14:47</p>
 */
public class DailyPractice_20240618 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String discountPrices(String sentence, int discount) {
            String[] words = sentence.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                if (word.startsWith("$")) {
                    if (word.matches("^\\$(\\d+\\.)?\\d+$")) {
                        words[i] = String.format("$%.2f",
                                calPrice(
                                        Double.parseDouble(word.substring(1)),
                                        discount));
                    }
                }
                sb.append(words[i]);
                if (i != words.length - 1) sb.append(' ');
            }
            return sb.toString();
        }

        private double calPrice(double price, int discount) {
            return price * (100.0 - discount) / 100;
        }
    }

}
