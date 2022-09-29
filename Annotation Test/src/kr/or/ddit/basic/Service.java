package kr.or.ddit.basic;

import java.io.Serializable;

public class Service implements Serializable {

	@PrintAnnotation
	public void method1() throws Exception {
		System.out.println("메서드1에서 출력되었습니다.");
	}
	
	@PrintAnnotation("%") // value는 하나만 있으면 생략해도 됨
	public void method2() {
		System.out.println("메서드2에서 출력되었습니다.");
	}
	
	@PrintAnnotation(value = "#", count = 25) // 이거는 생략 안 됨. 뭔가 다른 게 들어갔기 때문에
	public void method3() {
		System.out.println("메서드3에서 출력되었습니다.");
	}

}
