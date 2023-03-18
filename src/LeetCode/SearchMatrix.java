package LeetCode;/**
 * @Author: Patrick
 * @Date: 2022-11-01-14:45
 * @Description:
 */

/**
 * @description:
 * @author patrzhang
 * @date 01/11/2022 14:45
 * @version 1.0
 */
public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
//        searchMatrix.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},13);
        searchMatrix.searchMatrix(new int[][]{{1},{3}},1);
    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int up = 0;
        int down = m - 1;
        int mid = -1 ;
        while (up <= down){
            mid  = (up + down) >> 1;
            if (matrix[mid][0] <= target){
                up = mid+1;
            } else {
                down = mid - 1;
            }
        }


        int left = 0;
        int right = n - 1;
        int targetX = (up + down) >> 1;;

        while (left <= right){
            mid  = (left + right) >> 1;
            if(matrix[targetX][mid] == target){
                return  true;
            }

            if(matrix[targetX][mid] < target){
                left = mid + 1;

            } else{
                right = mid - 1;
            }

        }

        return false;


    }
}
