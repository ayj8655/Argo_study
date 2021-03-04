package baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_16918_봄버맨_O_210302 {

	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	static int R,C;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int time=2;
        
		char [][] arr = new char [R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		LinkedList<int[]> q = new LinkedList<>(); 	//위치를 저장할 리스트
		
		if(N %2 ==0) {		//입력이 짝수일경우 O만 프린트해줘도 되기때문에 종료
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print("O");
				}
				System.out.println();
			}
			System.exit(0);
		}
	/*
		0초 = 폭탄을 심는다 (최초)
		1초 대기
		2초 폭탄이 없는 위치에 폭탄 설치
		3초 0초에 심은 폭탄이 터진다
		
		4초 = 폭탄이 없는 위치에 폭탄을 설치한다.
		5초 = 2초에 심은 폭탄이 터진다.
		
		6초 = 폭탄이 없는 위치에 폭탄을 설치한다.
		7초 = 4초에 심은 폭탄이 터진다.

		짝수초에는 폭탄 설치
		홀수초에는 폭탄이 터진다
	*/		
		while (true) {
			
			if (time == N + 1) break;
			 
	        if (time % 2 == 0)
	        {
	        	for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(arr[i][j]=='O') q.add(new int[] {i,j});		//폭탄일 경우 폭탄 리스트에 저장
						if(arr[i][j] =='.') arr[i][j] = 'O';			//폭탄이 아닐경우 폭탄으로 변경
					}
				}
	        }
	        else
	        {
	        	while(!q.isEmpty()) {	//저장된 폭탄과 주변 폭파
					int[] x = q.poll();
					int i = x[0];
					int j = x[1];
					arr[i][j] = '.';
					
					for (int d = 0; d < 4; d++) {	//상하좌우 폭파
						int nx = i+dx[d];
						int ny = j+dy[d];
						if(nx>=0 && ny >=0 && nx< R && ny< C) {
							arr[nx][ny] = '.';
						}
					}	
				}	
	        }
	        time++;
		}
		print(arr);


	}
	private static void print(char[][] arr) throws IOException {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'O') bw.write('O');
                else bw.write('.');
			}
			bw.newLine();		
		}
		bw.flush();
        bw.close();
		
	}
}
