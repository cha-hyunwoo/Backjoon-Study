import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int z=Integer.parseInt(st.nextToken());

            if(x==0&&y==0&&z==0){
                break;
            }

            int []tri=new int[3];

            tri[0]=x;
            tri[1]=y;
            tri[2]=z;
            Arrays.sort(tri);

            if(tri[0]*tri[0]+tri[1]*tri[1]==tri[2]*tri[2]){
                sb.append("right").append("\n");
            }else{
                sb.append("wrong").append("\n");
            }
        }
        System.out.print(sb);
    }
}