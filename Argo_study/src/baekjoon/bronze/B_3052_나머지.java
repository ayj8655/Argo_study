package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class B_3052_나머지 {

	static int temp[];
	static int Ans;
	public static void main(String[] args)  throws Exception{
		System.setIn(new FileInputStream("res/input_B_3052.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		temp = new int[42];
		
		for (int i = 0; i < 10; i++) 
			temp[Integer.parseInt(br.readLine()) % 42] = 1;
		
		
		for (int i = 0; i < 42; i++) 
			if(temp[i]==1)
				Ans++;
		
		System.out.println(Ans);
		
		
		
		
		
	
	}
}