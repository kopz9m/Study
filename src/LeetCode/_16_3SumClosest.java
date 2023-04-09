package LeetCode;

import java.util.Arrays;

/**
 * @Author: Patrick
 * @Date: 2023-03-21-17:19
 * @Description:
 */
public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {

        int best = Integer.MAX_VALUE;

        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;

        // 枚举 a
        for (int i = 0; i < n; ++i) {

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                int diff = sum - target;
                if (Math.abs(diff) < Math.abs(best - target)) {
                    best = sum;
                }
                if (diff == 0) {
                    return sum;
                } else if (diff < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};

        _16_3SumClosest sumClosest = new _16_3SumClosest();
        sumClosest.threeSumClosest(nums, 1);


    }
}
