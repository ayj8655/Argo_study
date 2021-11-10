package bakejoon.bronze;

import java.io.*;
import java.util.*;

public class B_3040_백설공주와일곱난쟁이 {
	
	static int arr[];
	static int sel[];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		arr = new int[9];
		sel = new int[7];
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		combi(0,0);
		
		
		
	}
	
	public static void combi(int k, int idx) {
		if(k == sel.length) {
			
			int sum = 0;
			
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			
			if (sum == 100) {
				
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}
				System.exit(0);
			}
			
			
			return;
		}
		
		for (int i = idx; i <arr.length; i ++) {
			sel[k] = arr[i];
			combi(k+1,i+1);
		}
	}
	
}
