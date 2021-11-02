package old.baekjoon.bronze;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/8320
 * 직사각형을 만드는 방법
 * n = 6 일때 8이다.
 * 무조건 n만큼의 직사각형이 존재한다.
 * 
 * */
public class B_8320_직사각형을만드는방법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count=0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = i; j*i <= N; j++) {
				count++;
				//System.out.println(count);
			}
		}
		
		System.out.println(count);
		
	}
}
