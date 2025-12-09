import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int a[] = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int max = a[0];
		for (int j = 1; j < n; j++) {
			if (max < a[j]) {
				max = a[j];
			}
		}
		int min = a[0];
		for (int z = 1; z < n; z++) {
			if (min > a[z]) {
				min = a[z];
			}
		}
		System.out.print(min + " " + max);

	}
}