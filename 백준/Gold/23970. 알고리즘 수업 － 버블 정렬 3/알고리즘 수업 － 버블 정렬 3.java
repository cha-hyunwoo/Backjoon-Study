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

		int a[] = new int[n];
		int b[] = new int[n];
		int tmp = 0;
		int flag = 0;
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int s = 0; s < n; s++) {
			b[s] = Integer.parseInt(st.nextToken());
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
		for (int j = n - 1; j > 0; j--) {
			for (int r = 0; r < j; r++) {
				if (a[r] > a[r + 1]) {
					// 바꾸기 전 원래 맞았던 애들이면 점수 반납
					if (a[r] == b[r]) {
						flag--;
					}
					if (a[r + 1] == b[r + 1]) {
						flag--;
					}
					// 스왑
					tmp = a[r + 1];
					a[r + 1] = a[r];
					a[r] = tmp;
					
					// 맞게 바꾸면 점수 증가
					if (a[r + 1] == b[r + 1]) {
						flag++;
					}
					if (a[r] == b[r]) {
						flag++;
					}
					// 다 맞으면 출력
					if (flag == n) {
						System.out.print(1);
						return;
					}
				}
			}
		}
		System.out.print(0);
	}
}