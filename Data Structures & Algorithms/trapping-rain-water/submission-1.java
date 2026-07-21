class Solution {
     public int trap(int[] height) {
        int leftMax = 0;
        int[] leftHeights = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftHeights[i] = leftMax;
        }

        int rightMax = 0;
        int canBeTrapped = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            canBeTrapped += Math.min(leftHeights[i], rightMax) - height[i];
        }
        
        return canBeTrapped;
    }
}
