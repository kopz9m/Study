package LeetCode;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();

        int [] a = {1,3,2,0,2,1,7,9};
        n.sort(a,2);



        int[] h = {1,3,2};
        n.nextPermutation(h);
    }
    public void nextPermutation(int[] nums) {


        int length = nums.length;
        int min = 999;
        boolean found = false;
        int indexToSwapI = 0;
        int indexToSwapJ = 0;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= length - 1; j++) {

                if (nums[i] < nums[j] && nums[j]<min){
                    min = nums[j];
                    found = true;
                    indexToSwapJ = j;
                    indexToSwapI = i;
                }
            }

            if (found){
                int tmp = nums[indexToSwapI];
                nums[indexToSwapI] = nums[indexToSwapJ];
                nums[indexToSwapJ] = tmp;
                sort(nums,i + 1);
                break;
            }
        }

        if (!found){
            reverse(nums);
        }

    }
    // 反转
    void reverse (int[] array){
        int length = array.length;
        if (length%2 == 0){
            for (int j = 0; j < length/2; j++) {
                int tmp = array[j];
                array[j] = array[length - 1 - j];
                array[length - 1 - j] = tmp;
            }
        } else {
            for (int j = 0; j < (length-1)/2; j++) {
                int tmp = array[j];
                array[j] = array[length-1 - j];
                array[length-1 - j] = tmp;
            }
        }
    }

    void sort (int[] array,int index){
        int len = array.length;

        for (int i = index; i < len - 1; i++) {
            for (int j = index; j < len - 1 - (i- index); j++) {
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }




}
