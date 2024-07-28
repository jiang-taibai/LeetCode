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
            Block root = new Block(0, (int) 1e8 + 10);
            root.stackHeight = 0;
            List<Integer> res = new ArrayList<>();
            int maxStackHeight = 0;
            for (int[] position : positions) {
                int left = position[0], sideLength = position[1];
                Block block = new Block(left, sideLength);
                // 找到所有可能重叠的方块
                List<Block> blocks = overlapBlocks(root, block);
                // 计算这些方块中，最高的堆叠高度
                final int maxStackHeightOfOverlapBlock = blocks.stream().mapToInt(b -> b.stackHeight).max().orElse(0);
                // 把方块放到最高的方块上
                block.stackHeight = maxStackHeightOfOverlapBlock + sideLength;
                blocks.stream()
                        .filter(b -> b.stackHeight == maxStackHeightOfOverlapBlock)
                        .forEach(b -> b.upperBlocks.add(block));
                // 计算当前所有方块的堆叠高度
                maxStackHeight = Math.max(maxStackHeight, block.stackHeight);
                res.add(maxStackHeight);
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
