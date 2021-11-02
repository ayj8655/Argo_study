package old.baekjoon.silver;

import java.util.Scanner;
//실버 2
public class B_16987_계란으로계란치기_O_210302 {
	
	
	static int N,Ans;
	static int [] S;
	static int [] W;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = new int [N];
		W = new int [N];
	
		for (int i = 0; i < N; i++) {
			S[i] = sc.nextInt();	//내구
			W[i] = sc.nextInt();	//무게
			
		}
		//앞이 내구도, 뒤가 무게 
		//계란으로 치면 내구도는 상대 계란의 무게만큼 깎이게된다.
		//내구도 무게
		//8		5
		//1		100
		//3		5
		
		
		dfs(0);
		
		System.out.println(Ans);
		
	}



	private static void dfs(int k) {
		if(k>=N) {
			int cnt=0;
			for (int i = 0; i < N; i++) {
				if(S[i]<=0) cnt++;
			}
			
			if(Ans < cnt) Ans= cnt;
			
			return;
		}
		
		if (S[k] <=0) dfs(k+1);
		
		else {
			boolean flag = false;
			
			for (int i = 0; i < N; i++) {
				if( i ==k || S[i] <=0) continue;
				
				S[k] = S[k] - W[i];
				S[i] = S[i] - W[k];
				dfs(k+1);
				S[i] = S[i] + W[k];
				S[k] = S[k] + W[i];
				
			}
			
			if (!flag) dfs(N);			
		}		
	}
}