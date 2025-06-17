package com.ollierupprecht.dsa.leetcode;

public class FindClosestNumber {
        public static int findClosestNumber(int[] nums) {
            int closest = Math.abs(nums[0]);
            for (int i = 0; i < nums.length; i++) {
                closest = Math.min(Math.abs(nums[i]), closest);
                System.out.println(closest);
            }
            return closest;
        }
}
