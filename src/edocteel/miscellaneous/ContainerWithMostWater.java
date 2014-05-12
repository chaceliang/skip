package edocteel.miscellaneous;

/**
 * Created by chace on 5/12/14.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
