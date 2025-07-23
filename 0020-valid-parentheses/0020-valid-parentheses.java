class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                if((stack.peek() == '(' && s.charAt(i) == ')') || (stack.peek() == '{' && s.charAt(i) == '}')  || (stack.peek() == '[' && s.charAt(i) == ']' )) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}