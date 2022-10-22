package kr.or.ddit.basic;

class Util2 {
	
	public static <T extends Number> int compare(T t1, T t2) { //doubleValue는 Number클래스의 메소드이다. 그래서 상속 받아야 함

		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2); // 앞에 것이 크면 양수, 뒤에 것이 크면 음수, 같으면 0 / 오름차순
	}
}
/**
 * 제한된 타입 파라미터(Bounded Parameter) 예제
 * Util2에서 doubleValue()메서드를 쓰기 위해 제너릭 T에 extends Number을 해줌
 * 왜냐하면 doubleValue()메서드는 Number클래스의 메서드라서 그렇다.
 */
public class T03GenericMethodTest {
	public static void main(String[] args) {
		int result1 = Util2.compare(10, 20);
		
		System.out.println(result1);
		
		int result2 = Util2.compare(3.14, 3);
		
		System.out.println(result2);
		
//		Util2.compare("C", "JAVA"); // 에러발생
		
		
	}

}
