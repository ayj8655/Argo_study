package baekjoon.gold;

import java.util.*;
import java.io.*;

public class B_6497_전력난2 {
	
	
	static int M,N;
	static int[] parent;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO 자동 생성된 메소드 스텁
//			return this.weight - o.weight;					//가중치가 다 양수이면 이걸로 음수도있으면 밑으로
			return Integer.compare(this.weight,o.weight); //알아서 앞에꺼에서 뒤로 뺌 (크기검사해서 )
			
		}
		
		
	}
	
	static void make() {//크기가 1인 단위집합을 만든다.
		for (int i = 0; i < M; i++) {
			parent[i]=i;
		}
	}
	static int findSet(int a) {
		if(parent[a]==a) return a;
	//	return findSet(parents[a]);	//path compression 전
		return parent[a] = findSet(parent[a]);	//path compression 후
		
	}
	
	static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) return false;
		
		parent[bRoot] = aRoot;
		return true;
		
	}
	
	
	

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_B_6497.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			if (M == 0 && N == 0) break;

			edgeList = new Edge[N];

			int cost = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());

				edgeList[i] = (new Edge(x, y, z));
				cost += z;
			}
			Arrays.sort(edgeList);

			parent = new int[M];
			for (int i = 0; i < M; i++) {
				parent[i] = i;
			}

			make();
			int result = 0;
			int count = 0;	//선택한 간선수
			for (Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {	//싸이클이 발생하지 않았다면
					result += edge.weight;
					if(++count == N-1) break;
				}
			}

			sb.append(cost - result).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}