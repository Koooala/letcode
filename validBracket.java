package helloword.leetcode;

import java.util.Stack;

public class validBracket {

    private static boolean validBecket(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ')':
                    if (st.isEmpty() || st.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (st.isEmpty() || st.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (st.isEmpty() || st.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    st.push(s.charAt(i));
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        boolean j= validBecket("({)}[()]");
        System.out.print(j);
    }

}

