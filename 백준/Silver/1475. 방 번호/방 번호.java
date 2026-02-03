import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        int []set=new int[10];
        for(int i=0;i<n.length();i++){
            int num=n.charAt(i)-'0';
            set[num]+=1;
        }
        set[6]+=set[9];
        if(set[6]%2==0){
            set[6]/=2;
        }else{
            set[6]/=2;
            set[6]++;
        }
        int max=set[0];
        for(int i=1;i<9;i++){
            if(max<set[i]){
                max=set[i];
            }
        }
        System.out.print(max);
    }
}