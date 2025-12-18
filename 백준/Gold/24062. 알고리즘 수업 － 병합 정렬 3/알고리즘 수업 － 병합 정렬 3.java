import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	// 편의를 위해 배열 전역 변수 선언
	static int[] a;
	static int[] b;
	static int[] tmp;
	static int count = 0;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		a = new int[n];
		b = new int[n];
		tmp = new int[n];
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
				count++;
			}
			if (count == n) {
				System.out.print(1);
				System.exit(0);
			}
		}
		merge_sort(0, n - 1);

		// 못 찾고 끝나면 0 출력
		System.out.print(0);
	}

	public static void merge_sort(int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(p, q);
			merge_sort(q + 1, r);
			merge(p, q, r);
		}
	}

	public static void merge(int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		while (i <= q && j <= r) {
			if (a[i] <= a[j]) {
				tmp[t++] = a[i++];
			} else {
				tmp[t++] = a[j++];
			}
		}
		while (i <= q) {
			tmp[t++] = a[i++];
		}
		while (j <= r) {
			tmp[t++] = a[j++];
		}
		i = p;
		t = 0;
		while (i <= r) {
			if (a[i] == b[i])
				count--;
			a[i] = tmp[t++];
			if (a[i] == b[i])
				count++;
			if (count == n) {
				System.out.print(1);
				System.exit(0);
			}
			i++;
		}
	}
}
