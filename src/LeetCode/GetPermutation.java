package LeetCode;/**
 * @Author: Patrick
 * @Date: 2022-10-27-14:17
 * @Description:
 */

import java.util.*;

/**
 * @description:
 * @author patrzhang
 * @date 27/10/2022 14:17
 * @version 1.0
 */
public class GetPermutation {
    public static void main(String[] args) {
        GetPermutation combine = new GetPermutation();

        String res = combine.getPermutation(4,9);

        System.out.println(res);

    }
    public String getPermutation(int n, int k) {
        int len = n;

        boolean[] used = new boolean[len + 1];

        Deque<Integer> path = new ArrayDeque();

        List<Integer> res = new ArrayList<>();

        List<List<Integer>> listRes = new ArrayList<>();


        dfs(len,  1,0, k, path, used,listRes);

        StringBuffer stringBuffer = new StringBuffer();


        for (Integer a :
                listRes.get(listRes.size()-1)) {
            stringBuffer.append(a.toString());
        }

        return stringBuffer.toString();


    }
    private void dfs( int len, int begin,int depth, int indexToFind, Deque path, boolean[] used, List<List<Integer>> listRes) {

        if (depth == len ){
            listRes.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len + 1; i++) {

            if (!used[i]){
                used[i] = true;
                path.addLast(i);
                dfs(len,1 ,depth + 1,indexToFind,path,used,listRes);

                if (indexToFind == listRes.size()){
                    break;
                }

                path.removeLast();
                used[i] = false;
            }
        }
    }
}
