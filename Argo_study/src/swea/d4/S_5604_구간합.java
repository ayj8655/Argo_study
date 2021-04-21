package swea.d4;

import java.util.*;

public class S_5604_구간합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			long A = sc.nextLong();
			long B = sc.nextLong();
			long[] ans = new long[10];
			long point = 1;
			
			while (A <= B) {
				while (B % 10 != 9 && A <= B) {
					cal(B, ans, point);
					B--;
				}
				if (B < A) 
					break;
				
				while (A % 10 != 0 && A <= B) {
					cal(A, ans, point);
					A++;
				}
				
				A /= 10;
				B /= 10;
				
				for (int i = 0; i < 10; i++) {
					ans[i] += (B - A + 1) * point;
				}
				
				point *= 10;
			}
			
			long sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += (ans[i] * i);
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}

	public static void cal(long x, long[] ans, long point) {
		while (x > 0) {
			String s = String.valueOf(x);
			int xx = s.charAt(s.length()-1)-'0';
			ans[xx] += point;
			x /= 10;
		}
	}
}
