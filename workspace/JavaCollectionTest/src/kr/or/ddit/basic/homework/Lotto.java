package kr.or.ddit.basic.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("==========================");
			System.out.println("Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==========================");
			System.out.print("메뉴선택 : ");
			int menu = scanner.nextInt();
			System.out.println("");

			switch (menu) {
			case 1:
				// 1번을 선택하면 나오는 창
				System.out.println("Lotto 구입 시작");
				System.out.println("");

				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.print("금액 입력 : ");
				int paying = scanner.nextInt();
				System.out.println("");

				// 입력받은 금액으로 횟수와 거스름돈 정하기
				int frequency = paying / 1000;
				int change = paying % 1000;

				// 횟수만큼 돌아가는 반복문으로 나온 로또번호 출력
				System.out.println("행운의 로또번호는 아래와 같습니다.");

				for (int i = 1; i <= frequency; i++) {
					Set<Integer> intRnd = new HashSet<Integer>();
					while (intRnd.size() < 5) {
						int num = (int) (Math.random() * 45 + 1);
						intRnd.add(num);
					}
					List<Integer> lottoList = new ArrayList<Integer>(intRnd); // List에 Set으로 중복 없이 구한 intRnd(로또 번호)넣기
					Collections.sort(lottoList); // 오름차순으로 만들기
					System.out.printf("로또번호%d : %s\n", i, lottoList.toString());
//					System.out.println("로또번호" + i + " : " + lottoList); // 출력
				}
				System.out.printf("\n받은 금액은 %s원이고 거스름돈은 %s입니다.\n", paying, change);
				break;
			case 2:
				System.out.println("감사합니다.");
				return;
			}
		}
	}
}