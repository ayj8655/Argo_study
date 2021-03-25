package swea.d4;


import java.io.*;
import java.util.*;

public class S_1251_하나로_X {
	
	static class Node implements Comparable<Node> {
		int from, to;
		double weight;

		public Node(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.weight, o.weight);
		}
	}

	static int root[];
	static double arrx[], arry[];
	static double E;
	static List<Node> adjlist;

	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			arrx = new double[N + 1];
			arry = new double[N + 1];
			adjlist = new ArrayList<Node>();
			root = new int[N + 1];
			int cnt = 0;
			long result = 0;
			
			for (int i = 1; i <= N; i++) root[i] = i;

			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) arrx[i] = Double.parseDouble(st.nextToken());
			
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) arry[i] = Double.parseDouble(st.nextToken());
			
			E = Double.parseDouble(br.readLine());
			
			
			double start_x, start_y, end_x, end_y, dx, dy;
			for (int i = 1; i < N; i++) {
				start_x = arrx[i];
				start_y = arry[i];
				for (int j = i + 1; j <= N; j++) {
					end_x = arrx[j];
					end_y = arry[j];
					dx = (start_x - end_x) * (start_x - end_x);
					dy = (start_y - end_y) * (start_y - end_y);
					adjlist.add(new Node(i, j, dx + dy));
				}
			}
			Collections.sort(adjlist);
			
			
			while (cnt < adjlist.size()) {
				int from = adjlist.get(cnt).from;
				int to = adjlist.get(cnt).to;
				int res = find(from,to);
				if (res==1) { // 사이클 형성
					cnt++;
					continue;
				}
				make_union(from,to);
				result += adjlist.get(cnt).weight;
				cnt++;
			}
			
			sb.append("#").append(t).append(" ").append(Math.round(E*result)).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	

	public static int parent(int idx) {
		if (root[idx] == idx)
			return idx;
		return root[idx] = parent(root[idx]);
	}

	public static void make_union(int a, int b) {
		a = parent(a);
		b = parent(b);
		if(a<b) root[b]=a;
		else root[a]=b;
	}

	public static int find(int a, int b) {
		a = parent(a);
		b = parent(b);
		if(a==b) return 1;
		else return 0;
	}
}