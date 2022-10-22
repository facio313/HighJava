package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 파일 읽기 예제
 */
public class T05FileStreamTest {
	public static void main(String[] args) {
		
		// FileInputStream 객체를 이용한 파일 내용 읽기
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("d:/D_Other/test2.txt");
			
			int data = 0;
			
			while((data = fis.read()) != -1) {
				// 읽어온 내용 출력하기
				System.out.print((char) data);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	// 한글은 2바이트!(ASCII로는 한글을 못 나타냄. char기반의 String객체를 온전히 보관하여 보여줄 수 있음)
	// 바이트 기반 스트림에서는 깨질 수밖에 없음...바이트 기반 스트림은 1바이트씩 읽기 때문에
	}
}
