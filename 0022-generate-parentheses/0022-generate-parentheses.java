class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(res,"",0,0,n);
        return res;
    }
    static void backtrack(List<String> res, String s, int i, int j, int max){
        if(s.length() == max*2) {
            res.add(s);
            return;
        }
        if(i<max) {
            backtrack(res,s+"(",i+1,j,max);
        }
        if(j<i) {
            backtrack(res,s+")",i,j+1,max);
        }
    }
}