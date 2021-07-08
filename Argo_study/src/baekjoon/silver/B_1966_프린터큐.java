package baekjoon.silver;

import java.util.*;
import java.io.*;

public class B_1966_프린터큐 {
	
	static int T,N,M,cnt=0;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_B_1966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			cnt=0;
			
			N = Integer.parseInt(st.nextToken());//문서의 개수
			M = Integer.parseInt(st.nextToken());//몇번째로 인쇄되었는지 궁금한 문서
			
			LinkedList<Integer> q = new LinkedList<>();
			Queue<Integer> q2 = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) 
				q.add(Integer.parseInt(st.nextToken()));
			
			for (int i = 0; i < N; i++) {
				if(i==M) 
					q2.add(M);
				else 
					q2.add(5000);
			}
						
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
					if(q2.peek() == M) 
						sb.append(cnt+"\n");
						
			
					q2.poll();
					
				}
				
			}
			
		}
		
		
		System.out.print(sb);
		
	}

}
