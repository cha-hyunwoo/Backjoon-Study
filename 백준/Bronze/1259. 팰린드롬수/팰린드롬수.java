import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String pel = br.readLine();
            if (pel.equals("0")) {
                break;
            }
            int end = pel.length();
            int i;
            for (i = 0; i < (pel.length() / 2); i++) {
                if (pel.charAt(i) != pel.charAt(end - 1)) {
                    sb.append("no").append("\n");
                    break;
                }
                end--;
            }
            if (i == (pel.length() / 2)) {
                sb.append("yes").append("\n");
            }
        }
        System.out.print(sb);
    }
}