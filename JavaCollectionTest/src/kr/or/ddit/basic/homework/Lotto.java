package kr.or.ddit.basic.homework;

import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("==========================");
		System.out.println("Lotto 프로그램");
		System.out.println("--------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("==========================");
		System.out.print("메뉴선택 : ");
		int menu = scanner.nextInt();
		System.out.println("");
		
		switch(menu) {
		case1:
			break;
		case2:
			return;
		}
		
		System.out.println("Lotto 구입 시작");
		System.out.println("");
		
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액 입력 : ");
		int paying = scanner.nextInt();
		System.out.println("");
		
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		
	}
}

class Lotto 