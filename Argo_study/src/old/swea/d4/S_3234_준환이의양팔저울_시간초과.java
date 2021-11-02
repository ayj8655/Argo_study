package old.swea.d4;

import java.util.Arrays;
import java.util.Scanner;

public class S_3234_준환이의양팔저울_시간초과 {

	static int T,N,Ans;
	static int[] arr;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N];
			v = new boolean[N];
			
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			Ans=0;
			//기본 순열은 무조건 있고 이후에 올리는거에 따라 추가된다.
			permutation(0,0,0);
			
			System.out.printf("#%d %d\n", t, Ans);
		}
		
	}
	private static void permutation(int k, int left, int right) {
		if(k == N) {
			Ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			v[i]=true;
			int Weight = arr[i];
			
			permutation(k+1, left+Weight,right);
			if(right+Weight<=left) permutation(k+1, left,right+Weight);
			
			v[i]=false;
		}
		
		
	}

	

}
