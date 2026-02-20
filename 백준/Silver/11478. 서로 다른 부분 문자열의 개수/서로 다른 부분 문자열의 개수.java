import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();

        HashSet<String> set=new HashSet<>();

        // 시작점
        for(int i=0;i<s.length();i++){
            //끝점
            for(int j=i+1;j<=s.length();j++){
                // substring(i부터 j전까지 나오는 문자열)
                set.add(s.substring(i,j));
            }
        }
        System.out.print(set.size());
    }
}