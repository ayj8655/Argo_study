package swea.d3;

import java.util.Arrays;
import java.util.Scanner;

/*
규영이와 인영이의 카드게임
순열쓰는거일듯?



1
1 3 5 7 9 11 13 15 17
D3

 */
public class S_6808_규영이와인영이의카드게임 {

	static int T, Ac=0,Bc=0;
	static int[] arr;
	static int[] arr2;
	static int[] sel;
	static boolean[] v;
	static boolean[] ch;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int tem=0;
			Ac=0;
			Bc=0;
			arr = new int[9];
			arr2 = new int[9];
			sel = new int[9];
			ch = new boolean[19];
			v = new boolean[9];
			for (int i = 0; i < 9; i++) {
				arr[i] = sc.nextInt();
				ch[arr[i]] = true;
			}
			for (int i = 1; i <= 18; i++) if(!ch[i]) arr2[tem++]=i;
			
			permutation(0);
			
			System.out.printf("#%d %d %d\n",t,Ac,Bc);
		}
	
	}
	private static void permutation(int k) {
		if(k == sel.length) {
			int sum=0,sum2=0;
			for (int i = 0; i < 9; i++) {//arr가 이기는 수를 찾아라
				if (arr[i] > sel[i]) sum+= arr[i]+sel[i];
				else if (arr[i] < sel[i]) sum2 += arr[i]+sel[i];
			}
			
			
			if (sum > sum2) Ac++;
			else if (sum < sum2) Bc++;
			
			
			return;
		}
		
		
		for (int i = 0; i < arr2.length; i++) {
			if(!v[i]) {
				v[i] =true;
				sel[k]=arr2[i];
				permutation(k+1);
				v[i]=false;
				
				
			}
		}
		
		
		
	}
}
