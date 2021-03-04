package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 요세푸스 문제
 * 큐
 */
public class B_1158_요세푸스문제 {
	static int N,K;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int count=1;
		
		LinkedList<Integer> q= new LinkedList<>();
		StringBuilder st = new StringBuilder();
		
		st.append("<");
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		//주어진 k값만큼 뒤로 빼고 넣고 한다가 k오면 팝 그리고 다시 반복
		
		while (!(q.isEmpty())) {
			if(count !=K) {
				q.add(q.poll());
				count++;
			}
			else if(count ==K) {
				st.append(q.poll()+", ");
				count=1;
			}
		}
		st.setLength(st.length()-2);
		st.append(">");
		
		System.out.println(st.toString());
		
	}

}
