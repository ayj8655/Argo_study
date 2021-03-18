package baekjoon.gold;

import java.util.*;
import java.io.*;

//1967번 문제랑 똑같 (입력방식만다름)
//20210318 1회 풀이
public class B_1167_트리의지름 {
	
	static class Node{
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
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		adjlist = new Node[N+1];

		for (int i = 0; i < N; i++) {
			int from = sc.nextInt();
			while (true) {
				int to = sc.nextInt();
				if(to==-1) break;
				int we = sc.nextInt();
				adjlist[from] = new Node(to,we, adjlist[from]);
				adjlist[to] = new Node(from,we, adjlist[to]);
			}
				
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
