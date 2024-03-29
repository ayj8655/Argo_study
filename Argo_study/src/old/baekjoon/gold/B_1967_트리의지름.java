package old.baekjoon.gold;

import java.util.*;
import java.io.*;

//1167번 문제랑 똑같 (입력방식만다름)
//20210318 1회 풀이
public class B_1967_트리의지름 {
	
	static class Node{	//노드 클래스
		int vertexl;	//인접정접의 주소랑
		int we;			//가중치
		Node next;		//다음 노드
		
		public Node(int vertexl, int we, Node next) {
			this.vertexl = vertexl;			this.we = we;
			this.next = next;
		}
		public Node(int vertexl, int we) {
			this.vertexl = vertexl;			this.we = we;
		}
	}
	
	static int Ans=Integer.MIN_VALUE,second;
	static Node[] adjlist;
	static boolean [] v;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		adjlist = new Node[N+1];
		
		for (int i = 1; i < N; i++) {	//인접리스트 입력 및 생성
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int we = Integer.parseInt(st.nextToken());
			adjlist[from] = new Node(to,we, adjlist[from]);
			adjlist[to] = new Node(from,we, adjlist[to]);
		}
		
		v = new boolean[N+1];
		dfs(1,0);	
		v = new boolean[N+1];
		dfs(second,0);
		
		System.out.println(Ans);
	}
	private static void dfs(int start, int length) {
		
		v[start]=true;
		
		if(Ans < length) {
			Ans = length;
			second = start;
		}
		
		for (Node temp = adjlist[start]; temp!=null;temp = temp.next) {
			if(!v[temp.vertexl]) dfs(temp.vertexl,temp.we+length);
		}
		
	}
}
