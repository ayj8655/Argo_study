package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2493
 * 탑
 * 스택 사용
입력
5
6 9 5 7 4
출력
0 0 2 2 4

 * 첫 입력은 레이저를 수신하지 못한다 -> 0
 * 두번째 9는 6보다 크다 그렇다면 6은 9의 레이저를 수신 할 수 없다.
 * 세번째 5는 9보다 작다 그렇다면 5는 9의 레이저를 수신 할 수 있다.
 * 6은 9를 수신하지 못한다.
 * 9는 5를 수신할 수 있다.
 * 5는 7을 수신하지 못한다.
 * 9는 7을 수신할 수 있다.
 * 7은 4를 수신할 수 있다.
 * 
 */
public class B_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<>();		//값확인
		Stack<Integer> index = new Stack<>();	//인덱스 확인
		int N = Integer.parseInt(br.readLine());	
		
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int V = Integer.parseInt(str.nextToken());
			
			while(!st.isEmpty()) {
				if(st.peek() >= V) {
					System.out.print(index.peek()+ " ");
					break;
				}
				st.pop();
				index.pop();
				
			}
			if(st.isEmpty()) System.out.print("0 ");
			
			st.push(V);
			index.push(i);
			
		}
		
	}

}
