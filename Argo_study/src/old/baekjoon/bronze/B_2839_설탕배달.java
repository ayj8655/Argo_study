package old.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
설탕 배달

그리디
N 킬로그램 배달해야한다
봉지는 3이랑 5 킬로그램 봉지가 있다.



 */
public class B_2839_설탕배달 {

	static int N;
	static int count=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		if(N%5==0) {
			System.out.println(N/5);
			System.exit(0);
		}
		while (true) {
			N -= 3;
			count++;
			if(N%5==0) {
				count += N/5;
				System.out.println(count);
				break;
			}
			if(count>4) {
				System.out.println(-1);
				break;
				
			}
			if(N<0) {
				System.out.println(-1);
				break;
			}
		}
	}
}
