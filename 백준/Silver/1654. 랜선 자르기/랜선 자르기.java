import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); // 오영식이 이미 가지고 있는 랜선의 개수
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        // 랜선의 길이를 담아 둘 배열
        int[] arraySize = new int[k];
        for (int i = 0; i < k; i++) {
            int size = Integer.parseInt(br.readLine()); // 갖고 있는 랜선의 각각 길이
            arraySize[i] = size;
        }

        Arrays.sort(arraySize);

        long low = 1;
        long high = arraySize[k - 1];
        long answer = 0;
        while (low <= high) {
            long mid = (low + high) / 2; // 시도해 볼 랜선의 길이
            long count = 0; // 잘린 랜선의 총 개수

            // 모든 랜선의 길이를 mid로 잘라보기
            for (int i = 0; i < k; i++) {
                count += (arraySize[i] / mid);
            }

            if (count >= n) {
                // 개수가 충분할때
                answer = mid; // 현재 저장
                low = mid + 1; // 한 사이즈 다음 부터 탐색
            } else {
                // 개수 부족할때
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
