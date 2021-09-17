package com.coderjiang.DailyPractice.Monthly_2021_09;

import java.util.Scanner;

/**
 * <p>Creation Time: 2021-09-17 10:49:25</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_17 {

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            boolean[] check;
            for (int i = 0; i < 9; ++i) {
                check = new boolean[10];
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') continue;
                    if (check[board[i][j] - '0']) return false;
                    check[board[i][j] - '0'] = true;
                }
            }
            System.out.println("true");
            for (int i = 0; i < 9; ++i) {
                check = new boolean[10];
                for (int j = 0; j < 9; ++j) {
                    if (board[j][i] == '.') continue;
                    if (check[board[j][i] - '0']) return false;
                    check[board[j][i] - '0'] = true;
                }
            }
            int[][] indexes = {
                    {0, 2, 0, 2},
                    {0, 2, 3, 5},
                    {0, 2, 6, 8},

                    {3, 5, 0, 2},
                    {3, 5, 3, 5},
                    {3, 5, 6, 8},

                    {6, 8, 0, 2},
                    {6, 8, 3, 5},
                    {6, 8, 6, 8},
            };
            for (int[] index : indexes) {
                if (!checkBlock(board, index[0], index[1], index[2], index[3])) return false;
            }
            return true;
        }

        private boolean checkBlock(char[][] board, int u, int d, int l, int r) {
            boolean[] vis = new boolean[10];
            for (int i = u; i <= d; ++i) {
                for (int j = l; j <= r; ++j) {
                    if (board[i][j] == '.') continue;
                    if (vis[board[i][j] - '0']) return false;
                    vis[board[i][j] - '0'] = true;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a three-digit integer: ");
        StringBuilder a = new StringBuilder(scanner.next());
        if (!a.toString().matches("-?\\d+")) {
            throw new Exception(a + " is not a number!");
        }
        if (a.reverse().toString().equals(a.reverse().toString())) {
            System.out.println(a + " is a palindrome");
        } else {
            System.out.println(a + " is not a palindrome");
        }
    }

}
