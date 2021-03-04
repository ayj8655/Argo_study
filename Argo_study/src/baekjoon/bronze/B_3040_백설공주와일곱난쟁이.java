package baekjoon.bronze;

import java.util.Scanner;

/*
백설공주와 일곱 난쟁이
7
8
10
13
15
19
20
23
25

7
8
10
13
19
20
23
 */
public class B_3040_백설공주와일곱난쟁이 {
	static int[] arr;
	static int[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = new int[9];
		sel = new int [7];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		//조합중에서 100인거 찾기
		
		
		combination(0,0);
	}
	private static void combination(int k, int idx) {
		if(k==sel.length) {
			int sum=0;
			
			for (int i = 0; i < sel.length; i++) {
				sum+= sel[i];
			}
			if(sum == 100) {
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}
				System.exit(0);
			}
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			combination(k+1, i+1);
		}
		
	}
	
}
