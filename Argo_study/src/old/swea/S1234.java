package old.swea;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
[입력]

10개의 테스트 케이스가 10줄에 걸쳐, 한 줄에 테스트 케이스 하나씩 제공된다.

각 테스트 케이스는 우선 문자열이 포함하는 문자의 총 수가 주어지고, 공백을 둔 다음 번호 문자열이 공백 없이 제공된다.

문자열은 0~9로 구성되며 문자열의 길이 N은 10≤N≤100이다. 비밀번호의 길이는 문자열의 길이보다 작다.
 
[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답(비밀번호)을 출력한다.

10 1238099084  
16 4100112380990844

#1 1234
#2 4123
 */
public class S1234 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			
			ArrayList <Integer> arr = new ArrayList<>();
			
			String s = sc.next();
			for(int i = 0; i < N; i++) {
				int tmp = s.charAt(i) - '0';
				arr.add(tmp);
			}
			
			int i = 1;
			while(true) {
				if(arr.get(i) == arr.get(i-1)) {
					arr.remove(i);
					arr.remove(i-1);
					i = 1;
				}
				else {
					i++;
				}
				if(i >= arr.size())
					break;
			}
			
			System.out.print("#" + t + " ");
			for(int j = 0; j < arr.size(); j++) {
				System.out.print(arr.get(j));
			}
			System.out.println();
		}
	}
}
