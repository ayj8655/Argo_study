package baekjoon.silver;

import java.util.*;
import java.io.*;

public class B_17609_회문_X {

	//안됨 ㅎ
	
	public static void main(String[] args)throws Exception{
		System.setIn(new FileInputStream("res/input_B_17609.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			
			
			int length = str.length();
			char[] ar = new char[length];
			
			for (int i = 0; i < length; i++) {
				ar[i] = str.charAt(i);
			}
			boolean flag = true;
			boolean flag2 = true;
			int even = length/2;
			length = length-1;
		
	        for (int i = 0; i <= even; i++) {
	            if (!(ar[i] == ar[length])) {//좁혀오다가 만약 다른걸 만났다?
	                
	            	
	            	if(even-i == 0) {
	            		flag2=false;
	            		continue;
	            	}
	            	if ((ar[i] == ar[length-1])) {
	            		length--;
	            		flag=false;
	            		
	            	}else if ((ar[i+1] == ar[length])) {
	            		i++;
	            		flag=false;
	            		
	            	}else {
	            		
	            		flag2 = false;
	            		break;
	            	}

	            }
	           // System.out.println(ar[i] + " "+ ar[length]);
	            length--;
	        }
			
			
			if(flag && flag2) sb.append(0+"\n");//회문이면 0
			else if (!flag && flag2)sb.append(1+"\n");	//아니면 2
			else if(!flag2) sb.append(2+"\n");
		}
		
		System.out.print(sb.toString());
	
		
		

	}

}
