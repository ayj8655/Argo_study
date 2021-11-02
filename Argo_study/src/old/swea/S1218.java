package old.swea;

import java.util.Scanner;
import java.util.Stack;

/*
 * 1218
 * 괄호 짝 찾기
 * 
 * 
 * 
 * */

public class S1218 {

	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			N = sc.nextInt();
			String str = sc.next();
			
			Stack<Character> stack = new Stack();
			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				
				
				if(c == ')' && stack.peek() == '(') stack.pop();
				else if(c == ']' && stack.peek() == '[') stack.pop();
				else if(c == '}' && stack.peek() == '{') stack.pop();
				else if(c == '>' && stack.peek() == '<') stack.pop();
				else {
					stack.push(c);
				}
			}
			
			if(stack.isEmpty()) System.out.println("#" + t + " 1");
			else System.out.println("#" + t + " 0");
			
		}
		
	}

}
