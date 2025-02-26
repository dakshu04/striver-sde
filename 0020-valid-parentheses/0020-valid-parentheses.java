import java.util.Stack;

class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // Closing brackets case
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')) {
                    s.pop(); // Matched, pop the corresponding opening bracket
                } else {
                    return false; // Mismatched brackets
                }
            }
        }
        
        // Check if there are remaining opening brackets
        return s.isEmpty();
    }
}