package baekjoon;

import java.io.*;
import java.util.*;
public class test {

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_d4_1486.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			
		}
		
		System.out.print(sb.toString());
		br.close();
		
		
	}
}
