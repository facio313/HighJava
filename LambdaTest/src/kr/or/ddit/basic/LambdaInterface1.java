package kr.or.ddit.basic;


@FunctionalInterface // 함수적 인터페이스 => 추상메서드가 하나뿐인 인터페이스
public interface LambdaInterface1 {
	// 반환값이 없고 매개변수도 없는 추상메서드
	public void test();
}

@FunctionalInterface
interface LambdaInterface2 { // 따로 파일 만들지 않는 한 public은 한 번만 쓸 수 있다. class도 마찬가지
	// 반환값이 없고 매개변수는 있는 추상메서드
	public void test(int a);
}

@FunctionalInterface
interface LambdaInterface3 { 
	// 반환값도 없고 매개변수도 있는 추상메서드
	public int test(int a, int b);
}