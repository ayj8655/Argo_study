package old.baekjoon.bronze;

import java.util.Scanner;

public class B_18868_멀티버스1_20210219 {

	static int M,N,Ans;
	static int [][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i <M-1; i++) {
			for (int j = i+1; j < M; j++) {	//배열을 복사하여 값 비교
				if(diff(arr[i],arr[j])) Ans++;
			}
		}
		
		System.out.println(Ans);
		
	}

	private static boolean diff(int[] arr1, int[] arr2) {
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr1[i] > arr1[j]) {
					if(arr2[i] <= arr2[j]) return false;
				}else if(arr1[i] < arr1[j]) {
					if(arr2[i] >= arr2[j]) return false;
				}else {
					if(arr2[i] != arr2[j]) return false;
				}
			}
		}
		
		return true;
	}

}
