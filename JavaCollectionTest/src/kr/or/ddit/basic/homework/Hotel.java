package kr.or.ddit.basic.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 실행 처음 보이는 화면
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		System.out.println();
		Map<Integer, String> room = new HashMap<Integer, String>();

		// 실행 시 보이는 메뉴
		while (true) {
			System.out.println("");
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");
			System.out.println("");
			System.out.print("메뉴선택 => ");
			int choice = scanner.nextInt();
			System.out.println("");
			
			switch (choice) {
			case 1:
				System.out.println("어느 방에 체크인 하시겠습니까?");
				System.out.print("방 번호 입력 => ");
				int roomNum = scanner.nextInt();
				scanner.nextLine();
				System.out.println();
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.print("이름 입력 => ");
				String name = scanner.nextLine();
				room.put(roomNum, name);
				System.out.println("체크인 되었습니다.");
				break;
				// 방이 이미 예약되어있는 경우 예외처리 하기
			case 2:
				System.out.println("어느 방을 체크아웃 하시겠습니까?");
				System.out.print("방 번호 입력 => ");
				int typeRoomNum = scanner.nextInt();
				scanner.nextLine();
				room.remove(typeRoomNum);
				System.out.println("체크아웃 되었습니다.");
				break;
				// 방이 예약되어있지 않는 경우 체크아웃하는 예외처리 하기
			case 3:
				Set<Map.Entry<Integer, String>> entrySet = room.entrySet();
				Iterator<Map.Entry<Integer, String>> entryIt = entrySet.iterator();
				while(entryIt.hasNext()) {
					Map.Entry<Integer, String> entry = entryIt.next();
					System.out.printf("방 번호 : %d, 투수객 : %s\n", entry.getKey(), entry.getValue());
				}
				break;
				// 예약이 없는 경우 나타내는 예외처리 하기
			case 4:
				System.out.println("**************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("**************************");
				return;
			}
		}
	}
}