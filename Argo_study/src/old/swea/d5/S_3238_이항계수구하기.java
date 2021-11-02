package old.swea.d5;

import java.util.*;
import java.io.*;

public class S_3238_이항계수구하기 {

	static int P;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			P = Integer.parseInt(st.nextToken());

			long[] fac = new long[P + 1];
			fac[0] = 1;
			for (int i = 1; i <= P; i++)
				fac[i] = (fac[i - 1] * i) % P;
			
			long answer = 1;
			
			while (N > 0 && R > 0) {
				long n = N % P;
				long r = R % P;
				if (n < r) {
					answer = 0;
					break;
				}
				answer *= fac[(int) n];
				answer *= power((fac[(int) (n - r)] * fac[(int) r]) % P, P - 2) % P;
				answer %= P;
				N /= P;
				R /= P;
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

	static long power(long x, long y)  { 
		long res = 1L; 
        x = x % P;            
        while (y > 0) {    
            if (y % 2 == 1) 
                res = (res * x) % P; 
            y = y >> 1;
            x = (x * x) % P; 
        }  
        return res; 
    }
}