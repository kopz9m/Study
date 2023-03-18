package LeetCode;/**
 * @Author: Patrick
 * @Date: 2022-10-31-13:31
 * @Description:
 */

/**
 * @description:
 * @author patrzhang
 * @date 31/10/2022 13:31
 * @version 1.0
 */
public class Search_33 {

    public static void main(String[] args) {
        Search_33 search_33 = new Search_33();
        search_33.search(new int[]{4,5,6,7,0,1,2},0);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }
}
