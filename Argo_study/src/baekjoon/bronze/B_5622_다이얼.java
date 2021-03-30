package baekjoon.bronze;

import java.util.*;
import java.io.*;

public class B_5622_다이얼 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
        
		int Ans=0;
		int k = str.length();
		
		for(int i = 0 ; i < k ; i++) {
			switch(str.charAt(i)) {
			case 'A' : case 'B': case 'C' : 
				Ans += 3; 
				break;
                
			case 'D' : case 'E': case 'F' : 
				Ans += 4; 
				break;
                
			case 'G' : case 'H': case 'I' : 
				Ans += 5; 
				break;
                
			case 'J' : case 'K': case 'L' : 
				Ans += 6; 
				break;
                
			case 'M' : case 'N': case 'O' : 
				Ans += 7; 
				break;
                
			case 'P' : case 'Q': case 'R' : case 'S' :
				Ans += 8; 
				break;
                
			case 'T' : case 'U': case 'V' : 
				Ans += 9; 
				break;
                
			case 'W' : case 'X': case 'Y' : case 'Z' : 
				Ans += 10; 
				break;
			}
		}		
		System.out.print(Ans);

	}

}
