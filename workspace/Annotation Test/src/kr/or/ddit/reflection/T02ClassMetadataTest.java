package kr.or.ddit.reflection;

import java.lang.reflect.Modifier;

import kr.or.ddit.basic.Service;

public class T02ClassMetadataTest {
	public static void main(String[] args) {
		
		// Reflection이란 Class 클래스를 사용하여 특정 클래스에 대한 정보를 가져오는 기술을 말한다.
		
		// 클래스 오브젝트 생성하기
		Class<?> clazz = Service.class;
		
		System.out.println("심플클래스명 : " + clazz.getSimpleName());
		System.out.println("클래스명 : " + clazz.getName());
		System.out.println("상위클래스명 : " + clazz.getSuperclass().getName());
		
		// 패키지 정보 가져오기
		Package pkg = clazz.getPackage();
		System.out.println("패키지 정보 : " + pkg.getName());
		
		// 해당클래스에서 구현하고 있는 인터페이스 목록 가져오기
		Class<?>[] interfaces = clazz.getInterfaces();
		
		System.out.println("인터페이스 목록=> ");
		for(Class<?> inf : interfaces) {
			System.out.println(inf.getName() + " | ");
		}
		System.out.println();
		
		// 클래스의 접근제어자 정보 가져오기
		// (flag bit값 반환됨 => 접근제어자의 유무 체크정보)
		int modFlag = clazz.getModifiers();
		
		System.out.println("접근제어자 : " + Modifier.toString(modFlag));
	}
}
