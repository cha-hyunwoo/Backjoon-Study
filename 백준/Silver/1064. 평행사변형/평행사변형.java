import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int x1=Integer.parseInt(st.nextToken());
        int y1=Integer.parseInt(st.nextToken());

        int x2=Integer.parseInt(st.nextToken());
        int y2=Integer.parseInt(st.nextToken());

        int x3=Integer.parseInt(st.nextToken());
        int y3=Integer.parseInt(st.nextToken());

        if((y2-y1)*(x3-x2)==(y3-y2)*(x2-x1)){
            System.out.print(-1);
            return;
        }
        double []size=new double[3];
        size[0]=Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
        size[1]=Math.sqrt(Math.pow(x2-x3, 2) + Math.pow(y2-y3, 2));
        size[2]=Math.sqrt(Math.pow(x1-x3, 2) + Math.pow(y1-y3, 2));

        // 둘레 후보
        double[] circum=new double[3];
        circum[0]=2*(size[0]+size[1]);
        circum[1]=2*(size[1]+size[2]);
        circum[2]=2*(size[0]+size[2]);

        Arrays.sort(circum);
        System.out.println(circum[2]-circum[0]);
    }
}