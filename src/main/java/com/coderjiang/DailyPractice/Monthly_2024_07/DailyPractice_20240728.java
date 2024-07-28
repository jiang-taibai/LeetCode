package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-28 16:57:39</p>
 */
public class DailyPractice_20240728 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<Integer> fallingSquares(int[][] positions) {
            int n = positions.length;
            Block root = new Block(0, (int) 1e8 + 10);
            root.stackHeight = 0;
            List<Block> allBlocks = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            for (int[] position : positions) {
                int left = position[0], sideLength = position[1];
                Block block = new Block(left, sideLength);
                List<Block> blocks = overlapBlocks(root, block);
                int maxStackHeight = 0;
                for (Block bottomBlock : blocks) {
                    maxStackHeight = Math.max(maxStackHeight, bottomBlock.stackHeight);
                }
                final int _finalMaxStackHeight = maxStackHeight;
                List<Block> filterBlocks = blocks.stream().filter(b -> b.stackHeight == _finalMaxStackHeight).collect(Collectors.toList());
                block.stackHeight = maxStackHeight + sideLength;
                filterBlocks.forEach(b -> b.upperBlocks.add(block));
                allBlocks.add(block);
                res.add(allBlocks.stream().mapToInt(b -> b.stackHeight).max().getAsInt());
            }
            return res;
        }

        private List<Block> overlapBlocks(Block root, Block target) {
            List<Block> res = new ArrayList<>();
            if (root.isOverlap(target)) res.add(root);
            for (Block upperBlock : root.upperBlocks) {
                res.addAll(overlapBlocks(upperBlock, target));
            }
            return res;
        }

        static class Block {
            private final int left;
            private final int side;
            private int stackHeight = 0;
            private final List<Block> upperBlocks = new ArrayList<>();

            Block(int left, int side) {
                this.left = left;
                this.side = side;
            }

            boolean isOverlap(Block block) {
                return !((this.left >= block.left + block.side) || (this.left + this.side <= block.left));
            }
        }
    }

}
