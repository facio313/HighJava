package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 성능향상을 위한 보조스트림 예제
 */

public class T12BufferedIOTest {
	public static void main(String[] args) {
		
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("d:/D_Other/bufferTest.txt");

			// 버퍼의 크기를 지정하지 않으면 기본적으로 버퍼의 크기가 8192byte(8kb)로 설정된다.
			
			// 버퍼크기가 5인 스트림생성
			bos = new BufferedOutputStream(fos, 5); // 바이트 기반을 위한 보조 스트림
			
			for (char ch = '1'; ch <= '9'; ch++) {
//				fos.write(ch); // 이렇게 해도 똑같음 얘는 하나씩 주는 것이고
				bos.write(ch); // 얘는 모았다가 주는 것
			}
			
			bos.flush(); // 작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두 출력시킨다.(close 시 자동 호출됨)
			
					
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
