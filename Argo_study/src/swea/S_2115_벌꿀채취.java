package swea;

import java.util.*;
import java.io.*;


public class S_2115_벌꿀채취 {

	static int N,M,C;
	static int arr[][];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res_D4_2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			arr = new int [N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			System.out.println("#" + t + " " + getMAxBenefit());
			
			
			
			
			
			
		}
		
		
		
	}
	
	private static int getMAxBenefit() {
		
		return processCombination();
	}
	
	private static int processCombination() {
		
		int result = 0, aBenefit =0, bBenefit=0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {//첫열부터 연속된 M개 채취가 가능한 열까지, 일꾼 A의 선택
				
				//선택된 M개 벌통에서 얻을수 있는 최대이익
				maxSum = 0;
				makeMaxSubset(i, j, 0, 0, 0);
				aBenefit = maxSum;
				
				maxSum=0;
				bBenefit =0;
				//일꾼 B의 선택
				//일꾼 A와 같은행에서 튓쪽 열에서 선택
				for (int j2 = j+M; j2 <= N-M; j2++) {
					makeMaxSubset(i, j2, 0, 0, 0);//maxSum 나옴
					if(bBenefit < maxSum) bBenefit = maxSum;
					
				}
				
				//일꾼 A의 다음행부터 선택
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N-M; j2++) {
						makeMaxSubset(i2, j2, 0, 0, 0);
						if(bBenefit < maxSum) bBenefit = maxSum;
						
					}
				}
				
				if(result < aBenefit+bBenefit) result = aBenefit+bBenefit;
				
			}
		}
		
		
		
		
		
		return result;
	}
	
	static int maxSum=0;
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powerSum) {//최대 부분집합의 이익
		
		
		if(sum>C) return;
		
		//마지막 원소까지 다 부분집합에 고려해봤다면
		if(cnt == M) {
			if(maxSum<powerSum) maxSum = powerSum;
			return;
		}
		//선택
		makeMaxSubset(i, j+1, cnt+1, sum+arr[i][j], powerSum+(arr[i][j] * arr[i][j]));
		//비선택
		makeMaxSubset(i, j+1, cnt+1, sum, powerSum);
	}
	

}
