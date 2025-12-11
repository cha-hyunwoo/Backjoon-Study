import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		int xy[][]=new int[n][2];
		for(int i=0;i<n;i++) {
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		xy[i][0]=Integer.parseInt(st.nextToken());
		xy[i][1]=Integer.parseInt(st.nextToken());}
		
		// 정렬
		Arrays.sort(xy,(x1,x2)->{
			if(x1[0]==x2[0]) {
				return x1[1]-x2[1]; // 음수 리턴-> 앞에가 더 작음
			}else {
				return x1[0]-x2[0];
			}
		});
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(xy[i][0]).append(" ").append(xy[i][1]).append('\n');
		}
		
		System.out.println(sb);
		}
}