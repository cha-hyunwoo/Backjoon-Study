import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 거스름돈의 액수

        int count = 0; // 동전의 개수
        while (n >= 0) {
            if (n % 5 == 0) { // 5로 나누어떨어지면
                count += n / 5;
                break;
            } else { // 2원을 하나씩 빼기
                n -= 2;
                count++;
            }
        }
        if (n < 0) {
            System.out.print(-1);
        } else {
            System.out.print(count);
        }
    }
}