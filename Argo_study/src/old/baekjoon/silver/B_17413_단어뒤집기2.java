package old.baekjoon.silver;

import java.util.Scanner;
import java.util.Stack;

/* https://www.acmicpc.net/problem/17413
 * 단어 뒤집기 2
 * 스택 활용
 * '<' 를 만났을때 앞에있는 문자를 거꾸로 출력
 * 
 * */
public class B_17413_단어뒤집기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack st = new Stack();
		boolean flag = false;		//태그인지 아닌지 확인용
		
		String a = sc.nextLine();
		
		for (int i = 0; i < a.length(); i++) {	
			
			if (a.charAt(i) == '<') {		//태그 시작
				print(st); // < 검색시 태그 전까지 단어 뒤집기
				flag = true;
				System.out.print(a.charAt(i));
			} 
			else if (a.charAt(i) == '>') {	//태그 끝
				flag = false;	
				System.out.print(a.charAt(i));
			} 
			else if (flag) System.out.print(a.charAt(i));	//태그 안에있을경우 그냥 프린트해버리기
			else {
				
				if (a.charAt(i) == ' ') {		//공백을 만난다면 모두 팝
					print(st);
					System.out.print(a.charAt(i));
				}								
				else st.push(a.charAt(i));		//스택에 푸시
			}
		}
		print(st);

	}
		
		
	static void print(Stack st) {
		while (!st.empty()) {
			System.out.print(st.peek());
			st.pop();
		}
	}
}
