package kr.or.ddit.basic;

public class T03LambdaTest {
	static int stVar = 0;
	private String name = "";
	
	public void testMethod(final int temp) {
		
		final int localVar = 50;
		int kor = 100;
		
		/*
		 * 람다식 내부에서 사용되는 지역변수 모두 final이어야 한다.
		 * => 값이 바뀌지 않아야 한다는 것!
		 * 보통은 final을 붙이지 않으면 컴파일러가 자동으로 붙여준다.
		 * 단, 지역변수의 값을 변경하는 식이 있을 경우에는 자동으로 붙여주지 않는다.
		 */
		
		// 메서드 안에서 익명객체를 람다식으로 사용할 시 지연변수를 참조할 때
		// kor = 200; => 자동으로 final이 붙기 때문에 컴파일러가 체크해줌
		// final로 안 만들고 싶으면 멤버변수, static으로 올리면 됨! 메서드 안에서만 문제가 됨!
		
		// 람다식을 쓴다는 것은 익명객체를 쓴다는 것
		// 람다식에서 지역변수 사용하기
		LambdaInterface1 lam1 =
			() -> {
				System.out.println("temp = " + temp);
				System.out.println("localVar = " + localVar);
				System.out.println("kor = " + kor);
				System.out.println("stVar = " + stVar);
				System.out.println("name = " + this.name);
			};
		lam1.test();
	}
	
	public static void main(String[] args) {
		new T03LambdaTest().testMethod(200);
	}
}
