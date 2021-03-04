package jungol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/*
 * 정올 회의실 배정 그리디
6
1 1 10
2 5 6
3 13 15
4 14 17
5 8 14
6 3 12

3
2 5 4
 */
public class J_1370_회의실배정 {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		MeetingRoom[]m = new MeetingRoom[N];
		
		for (int i = 0; i < N; i++) {
			m[i] = new MeetingRoom(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		List<MeetingRoom> list = getSchedule(m);
		
		System.out.println(list.size());
		for (MeetingRoom meetingRoom : list) {
			System.out.print(meetingRoom.no + " ");
		}
		
	}

	static class MeetingRoom implements Comparable<MeetingRoom>{
		int no,start,end;

		public MeetingRoom(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(MeetingRoom o) {//종료시간이 빠른 순서로 정렬할거임
			int diff = this.end - o.end;
			return diff!=0?diff:this.start-o.start;	//종료시간 기준으로 오름차순 만들고 같으면 시작시간이 빠른 순으로 정렬
		}
	}
	
	public static List<MeetingRoom> getSchedule(MeetingRoom[]m) {
		ArrayList<MeetingRoom> list = new ArrayList<MeetingRoom>();//배정된 회의
		Arrays.sort(m);
		list.add(m[0]);	//첫회의는 무조건 배정
		for (int i = 1, size = m.length; i< size; i++) {
			if(list.get(list.size()-1).end <= m[i].start){
				list.add(m[i]);
			}
		}
		return list;
	}
}

