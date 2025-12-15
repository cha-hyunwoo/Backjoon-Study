import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int a[] = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int loc = 0;
		int newItem = 0;
		int count = 0;
		for (int j = 1; j < n; j++) {
			loc = j - 1;
			newItem = a[j];

			while (0 <= loc && newItem < a[loc]) {
				a[loc + 1] = a[loc]; // 저장
				count++;

				if (count == k) {
					System.out.print(a[loc + 1]);
					return;
				}
				loc--;
			}
			if (loc + 1 != j) {
				// 자기 자리에 넣는것도 저장 횟수
				a[loc + 1] = newItem;
				count++;
				if (count == k) {
					System.out.print(a[loc + 1]);
					return;
				}
			}
		}
		// 다 돌았는데도 저장 횟수가 k보다 작으면 -1출력
		System.out.print(-1);

	}
}