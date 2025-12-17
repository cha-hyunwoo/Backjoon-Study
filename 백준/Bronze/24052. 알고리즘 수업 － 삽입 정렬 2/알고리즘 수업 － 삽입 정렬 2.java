import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int a[] = new int[n];
		int loc;
		int newItem;
		int count = 0;
		st = new StringTokenizer(br.readLine(), " ");

		for (int z = 0; z < n; z++) {
			a[z] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n; i++) {
			loc = i - 1;
			newItem = a[i];
			while (0 <= loc && newItem < a[loc]) {
				a[loc + 1] = a[loc];
				loc--;
				count++;
				if (count == k) {
					for (int j = 0; j < n; j++) {
						sb.append(a[j]).append(" ");
					}
					System.out.print(sb);
					return;
				}
			}
			if (loc + 1 != i) {
				a[loc + 1] = newItem;
				count++;
				if (count == k) {
					for (int j = 0; j < n; j++) {
						sb.append(a[j]).append(" ");
					}
					System.out.print(sb);
					return;
				}
			}
		}
		System.out.print(-1);
	}
}