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
		int tmp;
		int count=0;
		st = new StringTokenizer(br.readLine(), " ");

		for (int z = 0; z < n; z++) {
			a[z] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=n-1;i>0;i--) {
			int max=a[0];
			int m=0;
			for(int j=1;j<=i;j++) {
				if(max<a[j]) {
					max=a[j];
					m=j;
				}
			}
			if(a[i]!=max) {
				tmp=a[i];
				a[i]=a[m];
				a[m]=tmp;
				count++;
				if(count==k) {
					System.out.print(a[m]+" "+a[i]);
					return;
				}
			}		
		}
		System.out.print(-1);
	}
}
