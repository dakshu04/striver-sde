class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                if(word.length() > 0) {
                    stack.push(word.toString());
                    word.setLength(0);             
                }
            }
        }
        if(word.length() > 0) {
            stack.push(word.toString());
        }
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
            if(!stack.isEmpty()) {
                ans.append(' ');
            }
        }
        return ans.toString();
    }
}