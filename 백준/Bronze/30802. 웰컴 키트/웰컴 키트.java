import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine()); // 참가자의 수

        int []size=new int[6];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<6;i++){
            size[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken()); // 티셔츠 묶음 수
        int p=Integer.parseInt(st.nextToken()); // 펜 묶음 수

        int tCount=0;
        for(int i=0;i<6;i++){
                tCount+=(size[i]/t);
            if(size[i]%t!=0){
                tCount++;
            }
        }
        sb.append(tCount).append("\n");

        int pCount=0;
        pCount+=n/p;
        sb.append(pCount).append(" ").append(n%p);
        System.out.print(sb);
    }
}