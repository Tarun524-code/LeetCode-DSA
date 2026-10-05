/*class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(char c : s.toCharArray()) {
            if(c=='(') {
                st.push(0);
            } else {
                int curr = st.pop();
                st.push(st.pop()+Math.max(1,2*curr));
            }
        }
        return st.peek();
    }
}*/
class Solution {
    public int scoreOfParentheses(String s) {
        int c = 0;
        int score=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                c++;
            } else {
                c--;
                if(s.charAt(i-1) == '(')
                    score += 1<<c;
            }
        }
        return score;
    }
}