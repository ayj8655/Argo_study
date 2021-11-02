package old.baekjoon.silver;

import java.util.Scanner;

public class B_2477_참외밭_O {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[] line = new int[6];
        for(int i = 0; i < 6; i++) {
            sc.nextInt();//방향은 버리자.
            line[i] = sc.nextInt();//길이만 기억.
        }
        //홀 짝 각각 최대값을 기억하자.
        int largeW = 0;//짝
        int largeH = 0;//홀
        for(int i = 0; i < 6; i++) {
            if( i % 2 == 0) {
                largeW = Math.max(largeW, line[i]);
            }
            else {
                largeH = Math.max(largeH, line[i]);
            }
        }
        //작은 사각형의 너비와 높이를 구해야됨.
        //작은 사각형의 너비가 될 조건은, 양옆의 라인의 길이의 합이 높이의 최대값이 되면 그녀석은 작은 사각형의 너비
        //작은 사각형의 높이가 될 조건은, 양옆의 라인의 길이의 합이 너비의 최대값이 되면 그녀석은 작은 사각형의 높이
        int smallW = 0;
        int smallH = 0;
        for(int i = 0; i < 6; i++) {
            if( i % 2 == 0) {
                //내 왼쪽(i - 1) 과 내 오른쪽(i + 1)의 합이 largeH가 되면 그녀석을 기억.
                if( largeH == line[(i+5)%6] + line[(i+1)%6] )
                    smallW = line[i];
            }
            else {
                //내 왼쪽과 내 오른쪽의 합이 largeW가 되면 그녀석을 기억.
                if( largeW == line[(i+5)%6] + line[(i+1)%6] )
                    smallH = line[i];
            }
        }
        System.out.println( (largeH * largeW - smallH * smallW ) * K );
    }
}