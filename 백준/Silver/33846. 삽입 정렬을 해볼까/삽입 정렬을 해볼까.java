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
		int k = Integer.parseInt(st.nextToken());

		int a[] = new int[n];
		st = new StringTokenizer(br.readLine(), " ");

		for (int z = 0; z < n; z++) {
			a[z] = Integer.parseInt(st.nextToken());
		}
		// 이젠 어레이솔트써야함
		Arrays.sort(a,0,k);
		StringBuilder sb = new StringBuilder();
					for (int j = 0; j < n; j++) {
						sb.append(a[j]).append(" ");
					}
					System.out.print(sb);			
			}		
	}
