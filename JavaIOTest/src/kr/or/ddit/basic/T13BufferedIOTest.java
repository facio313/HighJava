package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class T13BufferedIOTest {
	public static void main(String[] args) {
		
		// 문자기반의 Buffered 스트림 사용하기
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			fr = new FileReader("src/kr/or/ddit/basic/T12BufferedIOTest.java"); // 현재폴더는 프로젝트 폴더를 현재 위치로 인식함
////			fr = new FileReader("./src/kr/or/ddit/basic/T12BufferedIOTest.java"); 위와 같음 .-> 현재 위치
//			
//			int data = 0;
//			
//			while((data = fr.read()) != -1) {
//				System.out.print((char) data);
//			}
			
			// 한 줄씩 읽을 수 있도록 해주는 readLine()을 이용하기 위해 BufferedReader 이용하기
			br = new BufferedReader(fr);
					
			// br.readLine(); // 리턴값이 String이기 때문에 temp를 String으롱!
			String temp = "";
			int cnt = 1;
			while ((temp = br.readLine()) != null) {
				System.out.printf("%4d : %s\n", cnt++, temp);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
//				fr.close(); // 기반 스트림이기 때문에 보조 스트림만 꺼주면 알아서 꺼진다
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}