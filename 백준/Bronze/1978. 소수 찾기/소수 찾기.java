import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a[] = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());

		}
		// 약수는 2부터 루트까지 확인
		for (int j = 0; j < n; j++) {
			if (a[j] == 1) { // 1은 소수가 아님
				a[j] = -1;
			}
			for (int z = 2; z <= Math.sqrt(a[j]); z++) {
				if (a[j] % z == 0) {
					a[j] = -1;
					break;
				}
			}
			if (a[j] != -1) { // 소수 개수
				count++;
			}
		}
		System.out.print(count);
	}
}