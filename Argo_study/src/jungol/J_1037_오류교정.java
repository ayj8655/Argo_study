package jungol;

import java.util.Scanner;

public class J_1037_오류교정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N+1][N+1];
        //입력
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        //각 행과 열의 합을 더해봅니다.
        //각 행의 합이 홀수가 되는 행의 개수를 cntR에 저장할거임.
        //각 열의 합이 홀수가 되는 열의 개수를 cntC에 저장할거임.
        int r = 0,c = 0;
        //홀수가 되는 행이나 열이 발견되면 각각 r,c에 위치를 기억하자.
        //검사.
        for(int i = 1; i <= N; i++) {
            int sumR = 0;
            int sumC = 0;
            for(int j = 1; j <= N; j++) {
                sumR += map[i][j];
                sumC += map[j][i];
            }
            if( sumR % 2 != 0 ) {
                cnt++;
                r = i;
            }

            if( sumC % 2 != 0 ) {
                cnt++;
                c = i;
            }
        }


        //cntR과 cntC가 모두 0이면 OK
        if(cnt == 0)
            System.out.println("OK");
        //cntR과 cntC가 모두 1이면 Change bit
        else if( cnt == 2 && r != 0 && c != 0)
            System.out.println(String.format("Change bit (%d,%d)", r, c));
        //그 외의 경우라면, Corrupt
        else
            System.out.println("Corrupt");
    }
}