package baekjoon.silver;

import java.io.*;
import java.util.*;
public class B_2943_토끼_X {

	static int N,M,S,A,K;
	static int arr[];
	static int arr2[];
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_B_2943.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
	
		N = Integer.parseInt(st.nextToken());	//토끼 숫자
		M = Integer.parseInt(st.nextToken());	//날짜

		arr = new int [N+1];
		for (int i = 1; i < N+1; i++) {	//1부터 N번 까지 토끼 숫자 저장
			arr[i] = i;
		}
		
		for (int i = 1; i < N; i++) {	//K구하기
			K =i;
			if (K*K > N) {
				
				K=i-1;
				break;
			}
		}
		
		arr2 = new int [K];
		for (int i = 0; i < M; i++) {	
			st = new StringTokenizer(br.readLine()," ");
			S = Integer.parseInt(st.nextToken());	//구매한 딸기의 수
			A = Integer.parseInt(st.nextToken());	//딸기를 먹기 시작하는 토끼의 번호
			
			for (int j = A; j < A+S; j++) {//5부터 10까지
				arr[j] = 200000;
			}
			int cnt = 0, cnt2=0;
			for (int j = 1; j < N; j=K+j) {
				if(arr[j]==200000&& (j+K) < N) {
					//System.out.println(j);
					if(arr[j+1]==200000 && arr[j+2] ==200000) {
						cnt++;
						arr[j]=1;
						arr[j+1]=1;
						arr[j+2]=1;
					}
				}
			}
			for (int j = 0; j < N; j++) {
				if(arr[j]==200000) {
					cnt2++;
				}
			}
			System.out.println(cnt+" " + cnt2);
			//System.out.println(Arrays.toString(arr));
			for (int i1 = 1; i1 < N+1; i1++) {	//1부터 N번 까지 토끼 숫자 저장
				arr[i1] = i1;
			}
			
		}
		
		
		
		br.close();
		
		
	}
}
