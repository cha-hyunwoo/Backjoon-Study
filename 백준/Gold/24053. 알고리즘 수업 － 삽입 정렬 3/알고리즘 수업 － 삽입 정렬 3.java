import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());

		int a[] = new int[n];
		int b[] = new int[n];

		int loc;
		int newItem;
		int flag = 0;
		st = new StringTokenizer(br.readLine(), " ");

		for (int z = 0; z < n; z++) {
			a[z] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int z1 = 0; z1 < n; z1++) {
			b[z1] = Integer.parseInt(st.nextToken());
		}
		for (int p = 0; p < n; p++) {
			if (a[p] == b[p]) {
				flag++;
			}
		}
		if (flag == n) {
			System.out.print(1);
			return;
		}

		for (int i = 1; i < n; i++) {
			loc = i - 1;
			newItem = a[i];

			while (0 <= loc && newItem < a[loc]) {
				// 바꾸기 전 점수 반납
				if (a[loc + 1] == b[loc + 1]) {
					flag--;
				}
				a[loc + 1] = a[loc];
				// 바꾼 후 점수 획득
				if (a[loc + 1] == b[loc + 1]) {
					flag++;
				}

				// 검사
				if (flag == n) {
					System.out.print(1);
					return;
				}
				loc--;
			}
			if (loc + 1 != i) {
				// 바꾸기 전 점수 반납
				if (a[loc + 1] == b[loc + 1]) {
					flag--;
				}

				a[loc + 1] = newItem;

				// 바꾼 후 점수 획득
				if (a[loc + 1] == b[loc + 1]) {
					flag++;
				}
				// 검사
				if (flag == n) {
					System.out.print(1);
					return;
				}
			}
		}
		System.out.print(0);
	}
}
