package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class threeSum {
    public static void main(String[] args) {
        threeSum th = new threeSum();
        th.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> setRes = new HashSet<>();


        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];

                if (sum<0){
                    i++;
                } else if(sum>0){
                    j--;
                } else if (sum == 0){
                    setRes.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    i++;
                }

//                int sum = nums[k] + nums[i] + nums[j];
//                if(sum < 0){
//                    while(i < j && nums[i] == nums[++i]);
//                } else if (sum > 0) {
//                    while(i < j && nums[j] == nums[--j]);
//                } else {
//                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
//                    while(i < j && nums[i] == nums[++i]);
//                    while(i < j && nums[j] == nums[--j]);
//                }
            }
        }

        res.addAll(setRes);
        return res;
    }
}
