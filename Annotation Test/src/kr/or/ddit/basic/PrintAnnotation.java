package kr.or.ddit.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
	Annotation에 대하여
	
	프로그램 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨 것(JDK1.5부터 지원)
	
	주석처럼 프로그램에 영향을 미치지 않으면서도 다른 프로그램에게 유용한 정보를 제공함.
	
	종류 :	1. 표준 annotation
			2. 메타 annotation(annotation을 위한 annotation, 즉 annotation을 정의할 때 사용하는 annotation
			
	annotation 요소의 규칙
	
	1. 요소의 타입은 기본형, String, enum, annotation, class만 허용함
	2. () 안에 매개변수를 선언할 수 없다.
	3. 예외를 선언할 수 없다.
	4. 요소의 타입에 타입 파라미터(제너릭타입글자)를 사용할 수 없다.
	
	주석은 그냥 보여주고 끝이지만 annotation은 컴파일러나 다른 프로그램에게 필요한 정보를 말해줌
 
 */

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER}) // 적용 대상 지정함(ex) PrintAnnotation을 어디서 쓸 건가?! => 메소드와 타입에서만 쓰겠다!)
@Retention(RetentionPolicy.RUNTIME) // 유지기간 지정함(기본:CLASS)
public @interface PrintAnnotation { //@interface @는 annotation을 선언하는 키워드
//	int id = 100; // 상수선언 가능. static final int id = 100; 일반적으로 상수는 잘 안 만듬
	String value() default "-"; // 그냥 (열고 )닫음, 메서드 선언 같지만 안에 뭐 쓰면 안 됨
	int count() default 20; // 기본 값은 20이다! 위에는 -이다! 라는 것
//	=> 나중에 써먹을라고 선언해놓은 것임

}
