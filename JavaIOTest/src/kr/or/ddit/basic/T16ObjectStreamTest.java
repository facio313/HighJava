package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 객체 입출력 보조 스트림 예제(직렬화와 역직렬화)
 * 디자인 패턴 중 데코레이션
 */
public class T16ObjectStreamTest {
	public static void main(String[] args) {

		// Member 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("일지매", 30, "서울");
		Member mem3 = new Member("이몽룡", 40, "부산");
		Member mem4 = new Member("성춘향", 50, "광주");

		ObjectOutputStream oos = null;

		try {
			// 객체를 저장하는 파일이지, 텍스트 파일은 아니여서 그냥 bin으로 저장
			// 보조스트림 두 개
			oos = new ObjectOutputStream(
				  new BufferedOutputStream(
				  new FileOutputStream("d:/D_Other/memObj.bin")));

			// 쓰기작업
			oos.writeObject(mem1); // 직렬화
			oos.writeObject(mem2); // 직렬화
			oos.writeObject(mem3); // 직렬화
			oos.writeObject(mem4); // 직렬화

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ObjectInputStream ois = null;

		try {
			// ObjectInputStream 보조 / FileInputStream 기반
			ois = new ObjectInputStream(
					new BufferedInputStream(
					new FileInputStream("d:/D_Other/memObj.bin")));
			
			Object obj = null;
			
			 // ObjectInputStream의 read.Object 메서드(Object로 리턴)
			while ((obj = ois.readObject(/*여기서 역직렬화*/)) != null) {
				// 읽어온 데이터를 원래의 객체형으로 변환 후 사용한다.
				Member mem = (Member) obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("-----------------------");
			}

		} catch (IOException ex) {
			// 더 이상 읽어올 객체가 없으면 예외 발생함
			// EndOfFileException
//			ex.printStackTrace();
			System.out.println("출력작업 끝...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

//class Member { // => NotSerializableException
class Member implements Serializable {
	// 자바는 Serializable 인터페이스를 구현한 클래스만 직렬화할 수 있도록 제한하고 있음.
	// Serializable은 껍데기만 있고 안에 추상메서드가 없음.
	// 그럼에도 있는 이유는 Member 타입도 되지만 Runnable처럼 Serializable 타입도 될 수 있음.
	// Serializable이란 표시, 마킹만 하는 것임!(옷의 태그 같은 것 -> 태그 인터페이스)
	// Serializable이면 직렬화해도 되는구나 라고 컴파일러가 알게 되는 것.(예외 발생 등)

	/*
	 * transient => 직렬화가 되지 않을 멤버변수에 지정한다.
	 * (*static 필드도 직렬화 대상에서 제외된다.) => 인스턴스 정보에 대한 데이터를 IO작업하는 것.
	 * static은 객체를 만들지 않고도 쓸 수 있는 것. 그래서 대상이 아님
	 * 직렬화 대상이 아닌 멤버변수는 기본값으로 저장된다.(참조형 변수 : null, 숫자형 변수 : 0)
	 * 데이터가 유지되지 않음(민감한 정보들!)
	 */
	
	private transient String name;
	private transient int age;
	private String addr;

	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}