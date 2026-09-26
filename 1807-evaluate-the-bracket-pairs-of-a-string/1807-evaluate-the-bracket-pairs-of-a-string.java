class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> hm = new HashMap<>();
        for(List<String> k : knowledge) {
            hm.put(k.get(0),k.get(1));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') {
                int closeidx = s.indexOf(')',i+1);
                String key = s.substring(i+1,closeidx);
                sb.append(hm.getOrDefault(key,"?"));
                i = closeidx;
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}