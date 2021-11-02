package old.swea.d4;

import java.io.*;
import java.util.*;
public class S_1486_장훈이의높은선반_pro {

	static int N,B,min;
	static int[] H;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1486.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			H = new int [N];
			
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
		//	subset(0,0);
			combi(0,0);
			sb.append("#").append(t).append(" ").append(min).append("\n");		
		}
		
		System.out.print(sb.toString());
		br.close();

	}

	private static void combi(int start, int sum) {
		if(sum>=B) {
			min=Math.min(min, sum-B);
			return;
		}
		if(start==N) return;
		
		for (int i = start; i < N; i++) {
			combi(i+1, sum + H[i]);
		}
	}
	
	
	private static void subset(int cnt, int sum) {
		if(sum>=B) {
			min=Math.min(min, sum-B);
			return;
		}
		if(cnt==N) return;
		
		subset(cnt+1,sum+H[cnt]);
		subset(cnt+1,sum);
	}

}
