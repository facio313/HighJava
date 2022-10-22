package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04ByteArrayIOTest {

	public static void main(String[] args) throws IOException {
		
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		byte[] temp = new byte[4]; // 자료를 읽을 때 사용할 배열
		
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int readBytes = 0;
		
		while((readBytes = bais.read(temp)) != -1) { //read(배열) : 반복횟수 
			// baos.write(temp);
			// [0, 1, 2, 3] [4, 5, 6, 7] [8, 9, 6, 7] -> 기존 데이터가 초기화가 안 돼서 6, 7이 그대로임
			baos.write(temp, 0, readBytes); // 그래서 파라미터가 3개짜리 써야 함
			System.out.println("temp : " + Arrays.toString(temp));
			
		}
		
		outSrc = baos.toByteArray();
		
		System.out.println(" inSrc => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));
	}
}
