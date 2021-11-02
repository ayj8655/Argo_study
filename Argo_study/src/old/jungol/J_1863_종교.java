package old.jungol;

import java.util.*;
import java.io.*;

public class J_1863_종교 {

	static int parents[];
	static int cnt[];

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 쌍의 수
        
        parents = new int[N+1];
        cnt = new int[N+1];   // 트리의 깊이를 측정
        
        for(int i = 1; i<=N; i++) {
            parents[i] = i;
        }
        
        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            union(a,b);
        }

        
        int cnt=0;
        for(int i = 1; i<=N; i++) {
        	if(i == parents[i]) cnt++;
        }
        
        System.out.println(cnt);
		
	}
	static int findSet(int a) {
		if(parents[a]==a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static void union(int x, int y) {
        int aRoot = findSet(x);
        int bRoot = findSet(y);

        if(cnt[aRoot]<cnt[bRoot]) {
            parents[aRoot] = bRoot;  
        }
        else {
            parents[bRoot] = aRoot;
            if(cnt[aRoot] == cnt[bRoot]) {
                cnt[aRoot]++;
            }
        }
    
	
	
	}
}
