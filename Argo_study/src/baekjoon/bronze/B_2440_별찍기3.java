package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class B_2440_별찍기3 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < a; i++) {
			for (int j = a-i; j >0 ; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		
		
	}

}
