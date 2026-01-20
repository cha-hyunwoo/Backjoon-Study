import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        String[][] sort = new String[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String age = st.nextToken();
            String name = st.nextToken();

            sort[i][0] = age;
            sort[i][1] = name;
        }

        Arrays.sort(sort, (o1, o2) -> {
            int age1 = Integer.parseInt(o1[0]);
            int age2 = Integer.parseInt(o2[0]);
            return age1 - age2;
        });

        for (int i = 0; i < n; i++) {
            sb.append(sort[i][0]).append(" ");
            sb.append(sort[i][1]).append("\n");
        }
        System.out.print(sb);
    }
}