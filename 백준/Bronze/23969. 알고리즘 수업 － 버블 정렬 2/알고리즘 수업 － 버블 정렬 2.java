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
		int tmp = 0;
		int count = 0;
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		for (int j = n - 1; j > 0; j--) {
			for (int r = 0; r < j; r++) {
				if (a[r] > a[r + 1]) {
					tmp = a[r + 1];
					a[r + 1] = a[r];
					a[r] = tmp;
					count++;
					if (count == k) {
						for (int z = 0; z < n; z++) {
							System.out.print(a[z] + " ");
						}
						return;
					}
				}
			}
		}
		if (count != k) {
			System.out.print(-1);
		}

	}
}