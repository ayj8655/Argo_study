package old.baekjoon.silver;


import java.io.*;
import java.util.*;


public class B_9012_괄호 {
	
	
	static int T;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_9012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
        
		for (int t = 0; t < T; t++) {
			
			boolean flag = true;
			String str = br.readLine();		
			Stack stack = new Stack();
			int length = str.length();
			
			for (int i = 0; i < length; i++) {
				
				if(str.charAt(i) == '(') {
					stack.push(str.charAt(i));
				}
				
				else if(str.charAt(i) == ')') {
					
					if(stack.isEmpty()) {
						flag=false;
						break;
					}
				
					if( (char) stack.pop() =='(') {
						continue;
					} else {
						flag = false;
						break;
					}
		
				}
						
			}
			
			if(!stack.isEmpty())
				flag = false;
			
			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");

		}

	}

}
