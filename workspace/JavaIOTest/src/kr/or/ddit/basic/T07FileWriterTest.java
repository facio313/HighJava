package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * FileWriter 예제
 */
public class T07FileWriterTest {
	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일로 저장하기
		
		// 콘솔(표준입력장치)과 연결된 입력용 문자 스트림 객체 생성하기
		// InputStreamReader => 바이트 기반 스트림을 문자 기반 스트림으로 변환해주는 보조 스트림이다. -> 기본(메인)스트림도 있다.
		InputStreamReader isr = new InputStreamReader(System.in);
		// 여기서 기본스트림은 System.in
		
		FileWriter fw = null; // 파일 출력용 문자 기반 스트림
		
		try {
			// 파일 출력을 위한 스트림 객체 생성하기
			fw = new FileWriter("d:/D_Other/testChar.txt");
			
			int data = 0;
			
			System.out.println("아무 거나 입력하세요.");
			
			// 콘솔에서 입력할 때 입력의 끝을 나타내는 표시는 ctrl + z키를 누르면 된다.
			// 엔터 쳐야 입력을 받아들이는 행동을 함
			
			while((data = isr.read()) != -1) {
				fw.write(data);
			}
			
			System.out.println("작업 끝...");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				// 파일 관련해서 close해놓는 게 좋음
				// jdbc도 그렇고
				isr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
