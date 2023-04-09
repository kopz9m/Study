package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Patrick
 * @Date: 2023-03-22-17:54
 * @Description:
 */
public class _18_4sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < len-3; i++) {

            if (i > 0&&nums[i]==nums[i-1]){
                continue;
            }

            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }

            for (int j = i+1; j < len-2; j++) {
                if (j > i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }

                int m = j + 1;
                int n = len-1;

                while(m<n){
                    if (nums[i] + nums[j] + nums[m] + nums[n] == target){
                        ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[j] , nums[m] , nums[n])));
                        while (m < n && nums[m] == nums[m + 1]) {
                            m++;
                        }
                        m++;
                        while (m < n && nums[n] == nums[n - 1]) {
                            n--;
                        }
                        n--;
                    } else if (nums[i] + nums[j] + nums[m] + nums[n] < target){
                        m++;
                    } else{
                        n--;
                    }
                }

            }
        }
        return ans;

    }
}
