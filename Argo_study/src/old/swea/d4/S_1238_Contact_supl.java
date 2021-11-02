package old.swea.d4;

import java.util.*;
import java.io.*;

public class S_1238_Contact_supl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt(); //데이터의 길이(출.도착의 개수, 출도착 쌍은 N/2)
            int start = sc.nextInt();
            int[][] adj = new int[101][101];
            int ans = 0; //정답을 저장할 변수
            for(int i = 0 ; i < N/2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                adj[from][to] = 1;
            }
            //큐와 방문배열을 준비한다.
            Queue<Node> queue = new LinkedList<>();
            boolean[] visited = new boolean[101];
            //시작점을 큐에 넣고, 시작점에 대해 방문체크를 한다.
            queue.add(new Node(start, 0));
            visited[start] = true;
            int cnt = 0;
            //큐에서 더이상 노드가 없을때까지.
            while(!queue.isEmpty()) {
                //    큐에서 하나 뽑아서.
                Node node = queue.poll();
                //    정답인지 등등 체크할 일 있으면 체크하고.
                //  cnt가 클수로 나중에 받은놈..ㅇㅇ num의 숫자가 가장 큰놈을 기억.
                if(cnt < node.cnt ) {
                    cnt = node.cnt;
                    ans = node.num;
                }
                else if( cnt == node.cnt){
                    ans = Math.max(ans, node.num);
                }

                //    다음 후보들(1부터 100중에 나와 연결되있는 노드들)
                for(int i = 1; i <= 100; i++) {
                    //    에 대해서 아직 방문안했으면서, 이번에 검사중인 노드와 연결된 친구가 있응면
                    //        방문체크하고 큐에 삽입.
                    if(!visited[i] && adj[node.num][i] == 1){
                        visited[i] = true;
                        queue.add(new Node(i, node.cnt + 1 ));
                    }

                }

            }
            System.out.println("#" + tc + " " + ans);
        }
    }
    static class Node{
        int num, cnt;
        Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
}