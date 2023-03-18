package LeetCode;

import sun.awt.image.ImageWatched;

import java.util.*;

public class IsValid {
    public static void main(String[] args) {

    }

    List<Character> leftList = new ArrayList<>(Arrays.asList(new Character[]{'(','{','['}));
    List<Character> rightList = new ArrayList<>(Arrays.asList(new Character[]{')','}',']'}));

    public boolean isValid(String s) {

        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character,Character> pairs = new HashMap<Character,Character>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');}};

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(pairs.containsValue(ch)){
                stack.push(ch);
            } else{
                if(pairs.get(ch) == stack.peek()){
                    stack.pop();
                    continue;
                } else return false;
            }

        }
        if (stack.size() > 0){
            return false;
        }
        return true;
    }
}
