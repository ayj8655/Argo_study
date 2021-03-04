package baekjoon.bronze;

import java.util.Scanner;

public class B_18512_점프점프_20210219 {
	
	static int X,Y,A,B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		X = sc.nextInt();
		Y = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		
		int [] arr = new int [101];	//100번안에 못만나면 영원히 못만나는것
		int [] arr2 = new int [101];
		arr[0] = A;
		arr2[0] =B;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i-1]+X;
			arr2[i] = arr2[i-1]+Y;
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i]== arr2[j]) {
					System.out.println(arr[i]);
					System.exit(0);
				}
			}
		}
		System.out.println(-1);
		
		
		
		
		
		
		
		
		
		
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] +" "+arr2[i]);
//			System.out.println();
//		}
		
		
	}

}
