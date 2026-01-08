import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String reverse = br.readLine();
        // int가 아닌 Integer 배열
        Integer[] sort = new Integer[reverse.length()];

        // 0을 빼줘야함
        for (int i = 0; i < reverse.length(); i++) {
            sort[i] = reverse.charAt(i) - '0';
        }

        Arrays.sort(sort, (o1, o2) -> o2 - o1);

        for (int i = 0; i < reverse.length(); i++) {
            sb.append(sort[i]);
        }
        System.out.print(sb);
    }
}
