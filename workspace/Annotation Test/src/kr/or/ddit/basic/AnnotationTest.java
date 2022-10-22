package kr.or.ddit.basic;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		

		// 선언된 메서드 목록을 조회하여, 메서드를 실행해보기
		Class<?> klass = Service.class;
//		Service service = new Service();
		Service service = (Service) klass.newInstance(); // new를 안 쓰고 reflection으로 객체 쓰는 방법
		Method[] methodArr = klass.getDeclaredMethods();
		// Class<?> klass = Service.class; 
		// Method[] methodArr = klass.getDeclaredMethods(); // 이 두 줄은 밑에 한 줄과 같음
//		Method[] methodArr = Service.class.getDeclaredMethods(); // Service.class - 객체 가져오기

		for (Method m : methodArr) {
			
			System.out.println(m.getName() + " => ");
			Annotation[] annos = m.getDeclaredAnnotations(); // 여러 개일 수 있기 때문에 배열로 받음

			for (Annotation anno : annos) {
				
				if (anno.annotationType().getSimpleName().equals("PrintAnnotation")) {
					PrintAnnotation printAnn = (PrintAnnotation) anno;
					for (int i = 0; i < printAnn.count(); i++) {
						System.out.print(printAnn.value());//value는 보통 기본(관례)
					}
				}
			}
			
			m.invoke(service); // invoke 실행하다
			
			System.out.println();
		}
	}
}