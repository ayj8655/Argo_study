package baekjoon.silver;

import java.util.*;
import java.io.*;
public class B_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = str.length();
		int Ans = 0;
 
		for (int i = 0; i < len; i++) {
 
			char ch = str.charAt(i);
 
			if(ch == 'c' && i < len - 1) {			
				if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') i++;		
				
			} else if(ch == 'd' && i < len - 1) {
				if(str.charAt(i + 1) == '-') i++;
				
				else if(str.charAt(i + 1) == 'z' && i < len - 2) {
					if(str.charAt(i + 2) == '=') i += 2;
				}
				
			} else if((ch == 'l' || ch == 'n') && i < len - 1) {	
				if(str.charAt(i + 1) == 'j') i++;
				
			} else if((ch == 's' || ch == 'z') && i < len - 1) {
				if(str.charAt(i + 1) == '=') i++;
			
		    }
		    
			Ans++;
 
		}
 
		System.out.println(Ans);

	}

}
