package kr.or.ddit.basic;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class T11FileEncodingTest {
	public static void main(String[] args) throws IOException {
		/*
		 * OutputStreamWriter => 바이트기반 출력용 객체를 문자 기반 출력용 객체로 변환하는 보조 스트림
		 * => 이 객체도 출력할 때 '인코딩방식'을 지정해서 출력할 수 있다. 
		 */
		
		// 키보드로 입력한 내용을 파일로 저장하는데,
		// out_utf8.txt파일은 'utf-8'인코딩 방식으로
		// out_ansi.txt파일은 'ms949'인코딩 방식으로 저장하시오.
		
		InputStreamReader isr = new InputStreamReader(System.in);
		
		// 파일 출력용
//		FileOutputStream fos1 = new FileOutputStream("d:/D_Other/out_utf8.txt");
//		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/out_ansi.txt");
//		
//		OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "UTF-8");
//		OutputStreamWriter osw2 = new OutputStreamWriter(fos2, "MS949");
		
		BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:/D_Other/utf8.txt"), "UTF-8"));
		BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:/D_Other/ansi.txt"), "MS949"));
		
		int data = 0;
		
		while((data = isr.read()) != -1) {
//			osw1.write(data);
//			osw2.write(data);
			bw1.write(data);
			bw2.write(data);
		}
		
		System.out.println("작업 완료...");
		
		isr.close(); // 보조 스트림을 닫으면 알아서 기본 스트림 먼저 닫음.
//		osw1.close(); // 해줘도 상관은 없음
//		osw2.close();
		bw1.close();
		bw2.close();
	}
}
