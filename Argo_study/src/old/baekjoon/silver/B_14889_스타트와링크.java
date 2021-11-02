package old.baekjoon.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
4
0 1 2 3
4 0 5 6
7 1 0 2
3 4 5 0

-출력 : 0
 * 
 * 
 */
public class B_14889_스타트와링크 {
	
	static int N,Ans = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(-1,0);
		System.out.println(Ans);
		//print(arr);
		
	}
	private static void dfs(int idx, int k) {
		
		if( k ==N/2) {
			mini();
			
			return;
		}
		
		for (int i = idx+1; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				dfs(i, k+1);
				v[i] = false;	
			}
		}
	}
	
	
	
	
	private static void mini() {
		int start =0, link =0;
		int a[] = new int[N/2]; // 선택된 사람들과 선택되지 않은 사람들이 저장 될 배열들
		int b[] = new int[N/2];
		int a_index=0,b_index=0; // 위의 두 배열에 값을 저장하기 위한 인덱스 변수
			
		for(int i=0;i<N;i++) { // 방문 배열을 탐색한다.
			if(v[i]) { // 선택된 사람들의 경우
				a[a_index++] = i; // a 배열에 저장
			}else { // 나머지 사람들은
				b[b_index++] = i; // b 배열에 저장
			}
		}
        
        // a와 b배열에 저장 된 사람들의 능력치를 계산
		start = divide(a);
		link = divide(b);
	
		int temp = Math.abs(start - link);
		
		if(temp == 0) {
			System.out.println(temp);
			System.exit(0);
		}
		Ans = Math.min(Ans, temp);
		
	}
	static int divide(int[] arr2) { // 두 팀의 능력치를 계산하는 메소드
		int result = 0;
		
		for(int i=0;i<arr2.length;i++) { // 두 사람을 선택해 능력치를 계산
			for(int j=i+1;j<arr2.length;j++) { // 조합이므로 앞선 사람의 다음 사람부터 탐색
				result += arr[arr2[i]][arr2[j]] + arr[arr2[j]][arr2[i]] ; // 두 경우를 모두 더해준다.'
			}			
		}
		return result; // 능력치 결과 리턴
	}
}
