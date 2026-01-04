import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        int m = Integer.parseInt(st.nextToken()); // 가져가려는 나무의 길이

        // 나무의 길이를 담아 둘 배열
        int[] tree = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(st.nextToken()); // 각각의 나무의 높이
            tree[i] = size;
        }

        Arrays.sort(tree);

        long low = 1;
        long high = tree[n - 1];
        long answer = 0;
        while (low <= high) {
            long mid = (low + high) / 2; // 시도해 볼 나무의 길이
            long count = 0; // 잘린

            // 모든 나무의 길이를 mid로 잘라보기
            for (int i = 0; i < n; i++) {
                if (tree[i] >= mid) {
                    count += (tree[i] - mid);
                }
            }
            if (count >= m) {
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
