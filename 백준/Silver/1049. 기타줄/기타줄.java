import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int pack[] = new int[m];
        int indi[] = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken());
            indi[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pack);
        Arrays.sort(indi);
        if (pack[0] < indi[0] * 6) {
            if ((n % 6) * indi[0] > pack[0]) {
                System.out.print((n / 6) * pack[0] + pack[0]);
                return;
            } else {
                System.out.print((n / 6) * pack[0] + (n % 6) * indi[0]);
                return;
            }
        }else{
            System.out.print( n * indi[0]);
            return;
        }
    }
}