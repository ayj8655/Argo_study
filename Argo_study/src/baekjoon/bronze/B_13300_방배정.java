package baekjoon.bronze;

import java.util.Scanner;

/*
20210222
16 2
1 1
0 1
1 1
0 2
1 2
0 2
0 3
1 3
1 4
1 3
1 3
0 6
1 5
0 5
1 5
1 6 


12


 * 
 */

public class B_13300_방배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] students = new int[2][7];
        //여.남 1~6학년 각각 인원수를 저장할 배열을 준비해두고.
        //입력되는 학생의 수를 각 위치에 세어주자.
        for(int i = 0; i < N; i++) {
            int S = sc.nextInt();
            int Y = sc.nextInt();
            students[S][Y]++;
        }
        //각 성별 각 학년을 돌면서 K를 기준으로 방이 몇개 필요한지를 세자.
        int ans = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 1; j < 7; j++) {
//                int s = students[i][j] / K;
//                if(students[i][j] % K != 0)
//                    s++;
//                ans += s;
                ans += (Math.ceil(students[i][j] / (double)K));
            }
        }
        System.out.println(ans);
    }
}
