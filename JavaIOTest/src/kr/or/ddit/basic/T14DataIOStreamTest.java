
package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class T14DataIOStreamTest {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("d:/D_Other/test.dat");
		
		// DataOutputStream은 출력용 데이터를 자료형에 맞게 출력해준다.
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("홍길동"); 	// 문자열 데이터 출력
		dos.writeInt(17);			// 정수형으로 데이터 출력하기
		dos.writeFloat(3.14f);		// 실수형(Float)으로 데이터 출력하기
		dos.writeDouble(3.14);		// 실수형(Double)으로 데이터 출력하기
		dos.writeBoolean(true);		// 논리형으로 데이터 출력하기
		
		System.out.println("출력 완료...");
		
		dos.close();
		//===============================================================
		// 출력한 데이터 읽어오기
		FileInputStream fis = new FileInputStream("d:/D_Other/test.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		System.out.println("문자열 자료 : "  + dis.readUTF());
		System.out.println("정수형 자료 : "  + dis.readInt());
		System.out.println("실수형(Float) 자료 : " + dis.readFloat());
		System.out.println("실수형(Double) 자료 : " + dis.readDouble());
//		System.out.println("실수형(Float) 자료 : " + dis.readFloat()); 순서가 달라지면 데이터가 완전 달라짐
		System.out.println("논리형 자료 : " + dis.readBoolean());
		
		dis.close();

		// 기본 타입의 데이터를 저장할 때는 보조 스트림을 사용하면 좋음
		// 홍길동 - 17 - 3.14f - 3.14 - true
		//   ?    - 4  -   4   -   8  -   1    바이트
		// 순서가 달라지면
		//   ?    - 4  -   8      -4- -   1    바이트
		// 읽는 게 이렇게 돼서 다른 값이 출력 됨!
	}
}
