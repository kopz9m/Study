package LeetCode;/**
 * @Author: Patrick
 * @Date: 2022-10-27-15:06
 * @Description:
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author patrzhang
 * @version 1.0
 * @description:
 * @date 27/10/2022 15:06
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
//        String str = "123456";
//        System.out.println(str.substring(2));
//        System.out.println(str.substring(2).length());

        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> res =  restoreIpAddresses.restoreIpAddresses("25525511135");

        res.forEach(System.out::println);
    }

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        Deque path = new ArrayDeque();
        List<String> res= new ArrayList<>();
        dfs(s,len,1,0,path,null,res);
        return res;
    }

    private void dfs(String str, int len, int begin, int depth, Deque path, boolean[] used, List<String> res) {

        if (depth > 4) {
            return;
        }

        if (depth == 4) {
            if (str.length() == 0){
                res.add(String.join(".",path));
            }
            return;
        }

        for (int i = begin; i < str.length() + 1; i++) {

            if (isValid(str.substring(0,i))) {

                path.addLast(str.substring(0,i));

                dfs(str.substring(i), len, 1, depth + 1, path, used, res);


                path.removeLast();

            }


        }
    }

    public boolean isValid(String str) {
        if (str.charAt(0) == '0' && str.length() > 1) {
            return false;
        }
        Long num = Long.parseLong(str);
        if (num > 255) {
            return false;
        }
        return true;
    }

}




