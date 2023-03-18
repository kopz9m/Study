package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public static void main(String[] args) {

        String haha = "()(())";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();


        System.out.println(longestValidParentheses.longestValidParentheses(haha));


    }
    public int longestValidParentheses(String s) {

        int[] dp = new int[s.length()];

        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            if (i -1 >= 0 && s.charAt(i) == ')'){
                if(s.charAt(i -1) == '('){
                    if(i >= 2){
                        dp[i] = dp[i - 2] + 2;
                    } else
                        dp[i] = 2;
                } else{

                    if (i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '('){
                        if (i - dp[i-1] - 2 >= 0){
                            dp[i] = dp[i - dp[i-1] - 2] + dp[i - 1] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }

                }

                max = Math.max(max,dp[i]);

            }

        }

        return max;

    }
}
