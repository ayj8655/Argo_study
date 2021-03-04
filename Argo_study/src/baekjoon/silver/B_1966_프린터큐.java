package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 
 * 프린터 큐
입력
3
1 0
5
4 2
1 2 3 4
6 0
1 1 9 1 1 1

출력
1
2
5
 */
public class B_1966_프린터큐 {
	
	static int T,N,M,cnt=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			cnt=0;
			N = sc.nextInt();//문서의 개수
			M = sc.nextInt();//몇번째로 인쇄되었는지 궁금한 문서.
			
			LinkedList<Integer> q = new LinkedList<>();
			Queue<Integer> q2 = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				q.add(sc.nextInt());
			}
			for (int i = 0; i < N; i++) {
				if(i==M) q2.add(M);
				else q2.add(5000);
			}
			
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(q.poll()+" " + q2.poll()+ " ");
//			}
			
			while(!q.isEmpty()){
				boolean rating = true;
				
				for (int i = 0; i < q.size(); i++) {	//전체를 돌면서 앞에꺼보다 큰게있는지 확인
					if(q.peek() < q.get(i)) {
						rating = false;
						break;
					}	
				}
				
				if(!rating) {		//한칸씩 밀어줘야함.
					q.add(q.poll());
					q2.add(q2.poll());
				}
				else {
					q.poll();
					cnt++;
					if(q2.peek() == M) {
						System.out.println(cnt);
						
					}

					q2.poll();
					
				}
				
			}
			
		}
		
	}

}
