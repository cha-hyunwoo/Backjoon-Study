import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());

        int A=a*y+b*x;
        int B=b*y;

        int result=mul(A,B);
        System.out.print((A/result+" "+(B/result)));

    }
    public static int mul(int num1,int num2){
        if(num1%num2==0){
            return num2;
        }
        return mul(num2,num1%num2);
    }
}