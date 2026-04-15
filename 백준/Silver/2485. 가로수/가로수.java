import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[]trees=new int[n];
        for(int i=0;i<n;i++){
            trees[i]=Integer.parseInt(br.readLine());
        }

        int gcd=0;
        for(int i=0;i<n-1;i++){
            int distance=trees[i+1]-trees[i];
            if(i==0){
                gcd=distance;
            }else{
                gcd=getGCD(gcd,distance);
            }
        }
        int totalTrees=(trees[n-1]-trees[0])/gcd+1;
        System.out.println(totalTrees-n);
    }
    public static int getGCD(int a,int b){
        while(b!=0){
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}