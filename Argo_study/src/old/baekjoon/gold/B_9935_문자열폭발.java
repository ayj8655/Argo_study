package old.baekjoon.gold;

import java.io.*;
import java.util.*;


public class B_9935_문자열폭발 {

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_B_9935.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		String boooom = br.readLine();
		
		Stack<Character> s1 = new Stack<Character>();
		Stack<Character> s2 = new Stack<Character>();
		
		for (int i = 0; i < input.length(); i++) {
			s1.push(input.charAt(i));
		}
		
		int index =0;
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		
			if(s2.peek() == boooom.charAt(boooom.length()-(index + 1))) index++;
			else {
                index = 0;
                if(s2.peek()==boooom.charAt(boooom.length()-(index+1))) index++;
            }
			
            if(index==boooom.length()) { 
                for(int i=0;i<boooom.length();i++) s2.pop();
                for(int i=0;i<boooom.length();i++) {
                	if(!s2.isEmpty()) s1.push(s2.pop());
                	else break;
                }
                index = 0;
            }
		}
		
		if(s2.isEmpty()) {
            System.out.println("FRULA");
        }
        else {
            while(!s2.isEmpty()) {
                sb.append(s2.pop());
            }
            System.out.println(sb.toString());
		
		br.close();
	
        }
	}
}
