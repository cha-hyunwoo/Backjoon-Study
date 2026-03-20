import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] a;
    static int[] op;
    static int max = Integer.MIN_VALUE; // -21억 정도
    static int min = Integer.MAX_VALUE; // 21억 정도

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 수의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4]; // 연산자 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(a[0],1);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int num, int index) {
        if (index == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--; // 연산자 사용

                if (i == 0) {
                    dfs(num + a[index], index + 1);
                }else if(i==1){
                    dfs(num-a[index],index+1);
                }else if(i==2){
                    dfs(num*a[index],index+1);
                }else if(i==3){
                    dfs(num/a[index],index+1);
                }
                op[i]++; // 연산자 복구
            }
        }
    }
}
