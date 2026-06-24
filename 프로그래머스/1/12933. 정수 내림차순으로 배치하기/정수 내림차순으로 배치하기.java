import java.util.Arrays;
class Solution {
    public long solution(long n) {
        String []arr=String.valueOf(n).split("");
        Arrays.sort(arr);
        
        StringBuilder sb=new StringBuilder();
        for(String s:arr){
            sb.append(s);
        }
        long answer=Long.parseLong(sb.reverse().toString());
        return answer;
    }
}