package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T03ByteArrayIOTest {

	public static void main(String[] args) throws IOException {
		
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		
		// 직접 복사하는 방법
		/*
		outSrc = new byte[inSrc.length]; // 공간 확보
		
		for(int i = 0; i < inSrc.length; i++) {
			outSrc[i] = inSrc[i];
		}
		*/
		
		// arraycopy를 이용한 배열 복사하기
		/*
		outSrc = new byte[inSrc.length]; // 공간 확보
		System.arraycopy(inSrc, 0, outSrc, 0, inSrc.length);
		*/
		
		// 스트림 클래스 이용하기
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int data = 0; // 읽어온 바이트 데이터를 저장할 변수
		// 스트림은 바이트 기반
		// byte는 1바이트 사용
		// int는  4바이트 사용
		// byte에서 1바이트 사용한 것을 int로 옮기는 것은 가능(왜냐면 4자리나 있으니까)
		// 근데 int에서 byte로 가는 건 데이터 손실이 있을 가능성이 많음
		// 밑에서 -1을 표현하기 위해 int를 쓰는 것!
		
		// read() => byte단위로 데이터를 읽어와 int형으로 반환한다.
		//			 더 이상 읽어올 자료가 없으면 -1을 반환한다.
		while((data = bais.read()) != -1) { // 이 구문 많이 씀
			baos.write(data); // 읽어온 것을 baos에 저장! / 데이터 출력하기
		}
		
		outSrc = baos.toByteArray();
		
		bais.close();
		baos.close();
		
		
		
		System.out.println(" inSrc => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));
	}
}
