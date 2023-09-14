class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();

        int leftMin = 0, leftMax = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                leftMin++;
                leftMax++;
            }
            else if(ch == ')'){
                leftMin = Math.max(leftMin-1, 0);
                leftMax--;

                if(leftMax < 0)
                    return false;
            }
            else{
                leftMin = Math.max(leftMin-1,0);
                leftMax++;
            }
        }

        return leftMin == 0;
    }
}