package old.baekjoon.silver;

import java.util.*;
import java.io.*;

//20210323 1
public class B_3079_입국심사 {
	
	static long N,M,max,Ans;
	static long arr[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_3079.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Long.parseLong(st.nextToken());	//심사대
		M = Long.parseLong(st.nextToken());	//친구수
		
		arr = new long [(int)N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		long left = 1;
        long right = max*M;
        long Ans = right;
        long mid=0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (isPossible(mid)) {
                Ans = Math.min(Ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
		System.out.println(Ans);
	}
	
	static boolean isPossible(long t) {
        long temp = 0;
        for (int i = 0; i < N; i++) {
            temp += t / arr[i];
        }
        return temp >= M;
    }
}
