import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        int[]alphabet=new int[26];
        for(int i=0;i<s.length();i++){
            alphabet[s.charAt(i)-'A']++;
        }

        int oddCount=0; // 홀수 개수인 알파벳 찾기
        int midIndex=-1;
        for(int i=0;i<26;i++){
            if(alphabet[i]%2!=0){
                oddCount++;
                midIndex=i;
            }
        }
        // 홀수가 2개 이상이면 불가
        if(oddCount>1){
            System.out.print("I'm Sorry Hansoo");
            return;
        }
        StringBuilder sb=new StringBuilder();
        // 왼쪽 절반 만들기
        for(int i=0;i<26;i++){
            for(int j=0;j<alphabet[i]/2;j++){
                sb.append((char)(i+'A'));
            }
        }
        
        // 가운데 글자
        String left=sb.toString();
        if(midIndex!=-1){
            sb.append((char)(midIndex+'A'));
        }
        
        // 오른쪽 절반
        StringBuilder reversePart=new StringBuilder(left).reverse();
        sb.append(reversePart);
        
        System.out.print(sb);
        
    }
}