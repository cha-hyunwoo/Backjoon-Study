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
		int tmp;
		int flag = 0;
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			if (a[i] == b[i]) {
				flag++;
			}
		}
		if (flag == n) {
			System.out.print(1);
			return;
		}
		for (int i = n - 1; i > 0; i--) {
			int max = a[0];
			int m = 0;
			for (int j = 1; j <= i; j++) {
				if (max < a[j]) {
					max = a[j];
					m = j;
				}
			}
			if (a[i] != max) {
				if (a[i] == b[i]) {
					flag--;
				}
				if (a[m] == b[m]) {
					flag--;
				}
				tmp = a[i];
				a[i] = a[m];
				a[m] = tmp;
				if (a[i] == b[i]) {
					flag++;
				}
				if (a[m] == b[m]) {
					flag++;
				}
				if (flag == n) {
					System.out.print(1);
					return;
				}

			}
		}
		System.out.print(0);
	}
}
