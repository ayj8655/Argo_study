package swea.d5;

import java.util.*;
import java.io.*;


public class S_3238_이항계수구하기_pro {

	static int P;
	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			long N = Long.parseLong(tokens.nextToken());
			long R = Long.parseLong(tokens.nextToken());
			P = Integer.parseInt(tokens.nextToken());

			long[] factorial = new long[P + 1];
			factorial[0] = 1;
			for (int i = 1; i <= P; i++) {
				factorial[i] = (factorial[i - 1] * i) % P;
			}

			long answer = 1;

			while (N > 0 && R > 0) {
				long n = N % P;
				long r = R % P;
				if (n < r) {
					answer = 0;
					break;
				}
				answer *= factorial[(int) n];
				answer *= pow((factorial[(int) (n - r)] * factorial[(int) r]) % P, P - 2) % P;
				answer %= P;
				N /= P;
				R /= P;
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static long pow(long a, long b) {
		if (b == 0)
			return 1;

		long n = pow(a, b / 2);

		if (b % 2 == 0) {
			return (n * n) % P;

		} else {
			return ((n * n) % P * a) % P;

		}
	}
}