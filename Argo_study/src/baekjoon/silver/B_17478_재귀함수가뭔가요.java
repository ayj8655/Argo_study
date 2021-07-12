package baekjoon.silver;

import java.io.*;
import java.util.*;


public class B_17478_재귀함수가뭔가요 {
	
	static String underbar ="";
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		recur(N);

		
		System.out.print(sb);
	}
	

	
	public static void recur(int N) {
		
		//따로 저장을 안하면 나중에 line이 안줄어든다.
		String line = underbar;
		
		//재귀함수의 종료
		if(N==0) {
			
			
			sb.append(line + "\"재귀함수가 뭔가요?\"\n");
			sb.append(line + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(line + "라고 답변하였지.\n");
			return;
		}
			//재귀함수 반복
			sb.append(line +"\"재귀함수가 뭔가요?\"\n");
			sb.append(line +"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			sb.append(line + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			sb.append(line + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		//줄 생성
		underbar += "____";
		
		recur(N-1);
		
		//맨 마지막
		
		
		sb.append(line + "라고 답변하였지.\n");
		
	}
}
