import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0; // sum점 저장할 변수
        double scoreSum = 0; // 학점의 총합
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subjects = st.nextToken();

            double score = Double.parseDouble(st.nextToken());

            String level = st.nextToken();
            if (level.equals("P")) { // P등급은 계산 X
                continue;
            }
            scoreSum += score;
            switch (level) {
                case "A+":
                    sum += (4.5 * score);
                    break;
                case "A0":
                    sum += (4.0 * score);
                    break;
                case "B+":
                    sum += (3.5 * score);
                    break;
                case "B0":
                    sum += (3.0 * score);
                    break;
                case "C+":
                    sum += (2.5 * score);
                    break;
                case "C0":
                    sum += (2.0 * score);
                    break;
                case "D+":
                    sum += (1.5 * score);
                    break;
                case "D0":
                    sum += (1.0 * score);
                    break;
                case "F":
                    break;
            }
        }
        System.out.printf("%.6f", sum / scoreSum);
    }
}