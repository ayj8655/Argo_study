package baekjoon.silver;

import java.util.*;
import java.io.*;

public class B_2302_극장좌석 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_2302.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int [41];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			arr[i] = arr[i-1]+ arr[i-2];	//자리바꾸는게 피보나치였음
		}
		
		int M = Integer.parseInt(br.readLine());
		int Ans = 1, temp = 1, VIP=0;
		
		for (int i = 0; i < M; i++) {	//중간에 VIP를 만나면 끊고 다시 피보나치 사용 
			VIP = Integer.parseInt(br.readLine());
			Ans *= arr[VIP-temp];	//arr[3] * arr[2] * arr[2] = 12
			temp = VIP+1;
		}
		
		Ans*= arr[N-temp+1];
		
		System.out.println(Ans);

	}

}
