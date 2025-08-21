package PRO.Lv2;

import java.util.Stack;

public class PRO_12973 {
    public static void main(String[] args) {
        Solution_12973 s = new Solution_12973();
        System.out.println(s.solution("baabaa"));
        System.out.println(s.solution("cdcd"));
    }
}
class Solution_12973 {
    public int solution(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();

        char[] arr = s.toCharArray();
        for (char c : arr){
            if (!stack.isEmpty()){
                if (stack.peek() == c) stack.pop();
                else stack.add(c);
            } else {
                stack.add(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}