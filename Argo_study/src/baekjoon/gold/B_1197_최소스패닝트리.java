package baekjoon.gold;

import java.util.*;
import java.io.*;


public class B_1197_최소스패닝트리 {

	static int V, E, parents[], Ans;
    static Edge[] edgeList;
    
    static class Edge implements Comparable<Edge> {
        int from, to, weight;
 
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_B_1197.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        V = Integer.parseInt(st.nextToken());   
        E = Integer.parseInt(st.nextToken());
        
        parents = new int[V + 1];
        edgeList = new Edge[E];
 
        for (int i = 0; i < E; i++) {//정보 입력
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from, to, weight);
        }
 
        int cnt = 0;
        
        Arrays.sort(edgeList);	// 간선 가중치 기준 오름차순 정렬
        
        make();	// 정점 초기화
        
        for (Edge edge : edgeList) {	 // 주어진 간선
            if(union(edge.from, edge.to)) {	 // 싸이클이 형성되지 않는다면
                Ans += edge.weight;
                if(++cnt == V - 1) break;
            }
        }
        
        System.out.println(Ans);
    }
 
    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot == bRoot) return false;
        parents[aRoot] = bRoot;
        return true;
    }
 
    private static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
 
    private static void make() {
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }
}
