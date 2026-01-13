import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        int num = 666; // 검사 시작 숫자

        while (true) {
            if (String.valueOf(num).contains("666")) {
                count++;
            }
            if (count == n) {
                System.out.print(num);
                break;
            }
            num++;
        }
    }
}