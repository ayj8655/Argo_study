package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//스태틱을 쓰면 터짐
//지역변수로 써야됨
//D4 
public class S_3234_준환이의양팔저울_통과 {

	static int T,N,Ans;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Ans=0;
			//기본 순열은 무조건 있고 이후에 올리는거에 따라 추가된다.
			permutation(arr,new boolean [N] ,0,0,0);
			
			System.out.printf("#%d %d\n", t, Ans);
		}
		
	}
	private static void permutation(int[] arr, boolean[] v, int k, int left, int right) {
		
//		if(right>left) return; 이걸로 조건걸고 아래 조건 지워도 가능
		
		if(k == arr.length) {
			Ans++;
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {	//순열 안에서 파워셋 돌리기
			if(v[i]) continue;
			v[i]=true;
			int Weight = arr[i];
			
			permutation(arr, v, k+1, left+Weight,right);
			if(right+Weight<=left) permutation(arr, v, k+1, left,right+Weight);
			
			v[i]=false;
		}
		
		
	}

	

}
