import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 연산의 수

        boolean[] s = new boolean[21]; //1~21번 인덱스 사용

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            int x = 0;
            if (!command.equals("all") && !command.equals("empty")) {
                x = Integer.parseInt(st.nextToken());
            }
            switch (command) {
                case "add":
                    if (!s[x]) {
                        s[x] = true;
                    }
                    break;
                case "check":
                    if (s[x]) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "remove":
                    if (s[x]) {
                        s[x] = false;
                    }
                    break;
                case "toggle":
                    if (!s[x]) {
                        s[x] = true;
                    } else {
                        s[x] = false;
                    }
                    break;
                case "all":
                    for (int j = 0; j < 21; j++) {
                        s[j] = true;
                    }
                    break;
                case "empty":
                    for (int j = 0; j < 21; j++) {
                        s[j] = false;
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}
