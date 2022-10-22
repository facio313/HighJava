package kr.or.ddit.board;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/*
위의 테이블을 작성하고 게시판을 관리하는
다음 기능들을 구현하시오.

기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
 
*/

public class BoardMain {
	
	private IBoardService boardService;
	
	public BoardMain() {
		boardService = BoardService.getInstance();
	}
	
	private Scanner scan = new Scanner(System.in);
	
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 새 글 작성");
		System.out.println("  2. 글 삭제");
		System.out.println("  3. 글 수정");
		System.out.println("  4. 글 검색");
		System.out.println("  5. 전체 목록 출력");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");	
	}
	
	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 새 글 작성
				insertBoard();
				break;
			case 2: // 글 삭제
				deleteBoard();
				break;
			case 3: // 글 수정
				updateBoard();
				break;
			case 4: // 글 검색
				searchBoard();
				break;
			case 5: // 전체 목록 출력
				listBoard();
				break;
			case 6: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}

	public void insertBoard() {
		
		System.out.println();
		
		System.out.println();
		System.out.print("제목 >> ");
		String title = scan.next();
		
		scan.nextLine();
		
		System.out.println();
		System.out.print("글쓴이 >> ");
		String writer = scan.nextLine();
		
		
		System.out.println();
		System.out.print("내용 >> ");
		String content = scan.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setTitle(title);
		bv.setWriter(writer);
		bv.setContent(content);
		
		int cnt = boardService.insertBoard(bv);
		
		if (cnt > 0) {
			System.out.println("\"" + title + "\" 새 글 작성 성공");
		} else {
			System.out.println("\"" + title + "\" 새 글 작성 실패!!");
		}

	}
	
	public void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 글 번호를 입력하세요.");
		System.out.print("번호 >> ");
		
		int no = scan.nextInt();
		
		int cnt = boardService.deleteBoard(no);
		
		if (cnt > 0) {
			System.out.println(no + "번 글 삭제 성공");
		} else {
			System.out.println(no + "번 글 삭제 실패");
		}
		
	}
	
	public void updateBoard() {
		boolean exist = false;
		
		int no = 0;
		
		do {
			System.out.println();
			System.out.println("수정할 글 번호를 입력하세요.");
			System.out.print("번호 >> ");
		
			no = scan.nextInt();
			
			exist = boardService.checkBoard(no);
			
			if(!exist) {
				System.out.println(no + "번 글이 존재하지 않습니다.");
				System.out.println("다시 입력해주세요.");
			}
		} while (!exist);
		
		System.out.println();
		System.out.print("제목 >> ");
		String title = scan.next();
		
		System.out.println();
		System.out.print("글쓴이 >> ");
		String writer = scan.next();
		
		scan.nextLine();
		
		System.out.println();
		System.out.print("내용 >> ");
		String content = scan.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setNo(no);
		bv.setTitle(title);
		bv.setWriter(writer);
		bv.setContent(content);
		
		int cnt = boardService.updateBoard(bv);
		
		if (cnt > 0) { // 안 뜰 때는 커밋이 안 돼있는 것!
			System.out.println(no + "번 글 수정 성공");
		} else {
			System.out.println(no + "번 글 수정 실패!!");
		}
		
	}

	public void searchBoard() {
		scan.nextLine();
		
		System.out.println();
		System.out.println("검색할 글 정보를 입력하세요.");
		
		System.out.println();
		System.out.print("글 번호 >> ");
		int no = scan.nextInt();
		
		scan.nextLine();
		
		System.out.println();
		System.out.print("책 제목 >> ");
		String title = scan.nextLine().trim();
		
		System.out.println();
		System.out.print("작가 >> ");
		String writer = scan.nextLine().trim();
		
		BoardVO bv = new BoardVO();
		bv.setNo(no);
		bv.setTitle(title);
		bv.setWriter(writer);
		
		List<BoardVO> list = boardService.searchBoard(bv);
		
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("번호\t제목\t글쓴이\t날짜\t\t내용");
		System.out.println("-------------------------------------------------------------");
		
		if (list.size() == 0) {
			System.out.println("글 정보가 존재하지 않습니다.");
		} else {
			
			for (BoardVO bv2 : list) {
				System.out.println(
								  bv2.getNo() 	+ "\t" 
								+ bv2.getTitle() 	+ "\t" 
								+ bv2.getWriter() 	+ "\t" 
								+ bv2.getDate() 	+ "\t" 
								+ bv2.getContent() 	+ "\t");
			}
			
		}
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("검색 작업 끝.");
	}
	
	public void listBoard() { // 리스트 타입으로 바꾸기
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("번호\t제목\t글쓴이\t날짜\t\t\t\t내용");
		System.out.println("-------------------------------------------------------------");
		
		List<BoardVO> list = boardService.listBoard();
		
		if(list.size() == 0) {
			System.out.println("글 정보가 존재하지 않습니다.");
		} else {
			
			for(BoardVO bv : list) {
				System.out.println(bv.getNo() + "\t"
						+ bv.getTitle() + "\t"
						+ bv.getWriter() + "\t"
						+ bv.getDate() + "\t"
						+ bv.getContent() + "\t");
		}
		
	}
		
	System.out.println("-------------------------------------------------------------");
	System.out.println("출력 작업 끝.");
		
	}
	
	public static void main(String[] args) {
		BoardMain board = new BoardMain();
		board.start();
	}
	
}
