package bakejoon.bronze;

import java.util.*;
import java.io.*;

public class B_2292_벌집 {
	
	
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_B_2292.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(br.readLine());

		int num = 1;
		int range = 2;
		
		if(N == 1) {
			System.out.print("1");
		}
		
		else {
			while(range <= N ) {
				range = range + (6*num);
				num++;
			}
		}
		
		System.out.print(num);
		
		
		
		
	}

}
