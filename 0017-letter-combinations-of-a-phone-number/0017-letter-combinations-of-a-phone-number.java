class Solution {
    HashMap<Integer, String> map;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        
        this.map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        return f(0, digits);
    }
    public List<String> f(int i, String digits){
        List<String> res = new ArrayList<>();
        
        if(i == digits.length()-1){
            String s = map.get(digits.charAt(i) - '0');
            for(char ch : s.toCharArray())
                res.add(ch+"");
            return res;
        }

        List<String> list = f(i+1, digits);
        for(String str : list){
            String s = map.get(digits.charAt(i) - '0');
            for(char ch : s.toCharArray()){
                res.add(ch + str);
            }
        }

        return res;
    }
}