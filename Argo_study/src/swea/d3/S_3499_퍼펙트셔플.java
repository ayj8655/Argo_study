package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
3
6
A B C D E F
4
JACK QUEEN KING ACE
5
ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA


#1 A D B E C F
#2 JACK KING QUEEN ACE
#3 ALAKIR LORD-JARAXXUS ALEXSTRASZA AVIANA DR-BOOM

D3

 */
public class S_3499_퍼펙트셔플 {

	static int T,N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> q = new LinkedList<String>();
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			//짝수일때
			if (N%2 ==0) {
				String[] name = new String[N/2];
				String[] name2 = new String[N/2];
				
				StringTokenizer str = new StringTokenizer(br.readLine());
				
				for (int i = 0; i < name.length; i++) {
					name[i] = str.nextToken();
				}
				for (int i = 0; i < name2.length; i++) {
					name2[i] = str.nextToken();
				}
						
	
				for (int i = 0; i < N/2; i++) {
					q.add(name[i]);
					q.add(name2[i]);
				}

				
			}
			else {
				String[] name = new String[(N/2)+1];
				String[] name2 = new String[N/2];
				
				StringTokenizer str = new StringTokenizer(br.readLine());
				
				for (int i = 0; i < name.length; i++) {
					name[i] = str.nextToken();
				}
				for (int i = 0; i < name2.length; i++) {
					name2[i] = str.nextToken();
				}
						

				for (int i = 0; i < N/2; i++) {
					q.add(name[i]);
					q.add(name2[i]);
				}
				
				q.add(name[name.length-1]);
				
			}
			
			System.out.printf("#%d ", t);
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
			
			
		}
		
	}

}
