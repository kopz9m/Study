package LeetCode;

public class maxArea {

    public int maxArea(int[] height) {
        int area = 0;
        int i = 0, j = height.length - 1;

        while(i < j){
            area = Math.max(Math.min(height[i] , height[j]) * (j - i),area);
            if (height[i] < height[j]){
                i++;
            } else if (height[i] > height[j]){
                j--;
            } else if(height[i+1] < height[j-1]){
                j--;
            } else {
                i++;
            }
        }
        return area;
    }
}
