class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int leftMax = height[left];
        int rightMax = height[right];
        
        int totalVol = 0;
        
        while (left < right) {
            if (leftMax <= rightMax) {
                ++left;
                totalVol += Math.max(Math.min(leftMax, rightMax) - height[left], 0);
                leftMax = Math.max(leftMax, height[left]);
            } else {
                --right;
                totalVol += Math.max(Math.min(leftMax, rightMax) - height[right], 0);
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        
        return totalVol;
    }
}
