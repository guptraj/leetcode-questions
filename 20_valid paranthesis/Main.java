import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(')
                st.push(c);
            else {
                if (st.size() == 0) {
                    return false;
                }
                if (c == '}' && st.peek() != '{')
                    return false;
                else if (c == ')' && st.peek() != '(')
                    return false;
                else if (c == ']' && st.peek() != '[')
                    return false;
                else
                    st.pop();

            }
        }
        return st.size() == 0;

    }
}