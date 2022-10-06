package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class T08FileReaderTest {
	public static void main(String[] args) {
		
		// 문자 기반 스트림을 이용한 파일 내용읽기
		FileReader fr = null;
		
		try {
			// 문자 단위의 입력을 담당하는 Reader 객체 생성
			fr = new FileReader("d:/D_Other/testChar.txt");
		
			int data = 0;
			
			while((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 문자로 받아왔기 때문에 한글이 안 깨짐
	}
}
