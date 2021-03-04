package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class J_1205_조커_O {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        // 정렬하자.
        Arrays.sort(arr);
        // 맨앞에 모인 0의 개수를 세자.
        int jokerCnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] != 0)
                break;
            jokerCnt++;
        }
        //모두 조커이면 답은 N이고 아니면, 최소값인 0으로 일단 초기화
        int ans = (jokerCnt == N) ? N : 0;
        // 0이 끝나는 지점부터, 끝까지를 검사 (해당지점을 시작점으로 해서 만들어지는 스트레이트의 길이를 검사)
        for(int i = jokerCnt; i < N; i++) {
            // 첫 숫자를 가장최근의 수로 기억
            int lastNum = arr[i];
            // 스트레이트의 길이는 현재 1
            int cnt = 1;
            int joker = jokerCnt;
            // 해당지점 다음칸부터 끝까지를 검사 ( 스트레이트가 얼마나 길어지는지 검사 cnt에 )
            for(int j = i + 1; j < N; j++) {
                // 검사하는 숫자가 최근수와 같다면 그냥 다음으로 이동
                if(lastNum == arr[j])
                    continue;
                // 검사하는 숫자가 최근수와 1큰 경우, 스트레이트 길이 하나 증가시키고 최근수 변경하고 다음으로 이동
                if( arr[j] == lastNum + 1 ) {
                    cnt++;
                    lastNum = arr[j];
                    continue;
                }
                // 위에 안걸렸는데, 조커가 없는 경우, break떄려쳐
                if(joker == 0)
                    break;
                // 최근수1증가, 스트레이트길이1증가, 조커1감소, 검사하는 위치 한번 더 위에부터 반복
                // 조커가 남아있다면, 알아낸 스트레이트길이 + 조커
                lastNum++;
                cnt++;
                joker--;
                j--;
            }
            ans = Math.max(ans, cnt + joker);

        }
        System.out.println(ans);
    }
}