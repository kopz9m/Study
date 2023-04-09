package LeetCode;


/**
 * @Author: Patrick
 * @Date: 2023-04-03-17:38
 * @Description:
 */
public class _1053_Previous_Permutation_With_One_Swap {
    public int[] prevPermOpt1(int[] arr) {

        int len = arr.length;

        int leftIndex = Integer.MIN_VALUE;
        int rightIndex = Integer.MIN_VALUE;
        int leftValue = Integer.MAX_VALUE;
        int rightValue = Integer.MIN_VALUE;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    if (arr[j] > rightValue) {
                        leftIndex = i;
                        rightIndex = j;
                        leftValue = arr[i];
                        rightValue = arr[j];
                    }
                }
            }
            rightValue = Integer.MIN_VALUE;
        }
        if (leftIndex >= 0) {
            int tmp = arr[leftIndex];
            arr[leftIndex] = arr[rightIndex];
            arr[rightIndex] = tmp;
        }
        return arr;
    }
}
