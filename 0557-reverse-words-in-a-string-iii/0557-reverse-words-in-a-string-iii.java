class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringBuilder str = new StringBuilder();
            while(i<n && s.charAt(i) != ' '){
                str.append(s.charAt(i)+"");
                i++;
            }
            
            list.add(str.toString());
        }

        StringBuilder res = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            String rev = reverse(list.get(i));

            if(i == list.size()-1)
                res.append(rev);
            else
                res.append(rev+" ");
        }

        return res.toString();
    }
    private String reverse(String str){
        char[] arr = str.toCharArray();
        int i=0, j=arr.length-1;
        while(i<=j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
        return new String(arr);
    }
}