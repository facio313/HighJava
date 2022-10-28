package kr.or.ddit.basic;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class T08ServletFilter2 implements Filter{
/*
	서블릿 필터에 대하여...
	
	1. 사용목적
	- 클라이언트의 요청을 수행하기 전에 가로채 필요한 작업을 수행할 수 있다.
	- 클라이언트에 응답 정보를 제공하기 전에 응답 정보에 필요한 작업을 수행할 수 있다.
	
	2. 사용 예
	- 인증 필터
	- 데이터 압축 필터
	- 인코딩 필터
	- 로깅 및 감사 처리 필터
	- 이미지 변환 필터 등
 */
	@Override
	public void destroy() {
		// 필터 객체가 우베 컨테이너에 의해서 서비스로부터 제거되기 전에 호출됨
		System.out.println("T08ServletFilter2.destroy()" + " 호출됨");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("T08ServletFilter2.doFilter()" + " 시작...");

		// 서블릿 수행 시간 계산하기
		long startTime = System.nanoTime();
		
		// 필터체인을 실행한다.(요청 및 응답 객체 전달한다.)
		chain.doFilter(request, response); // doFilter() -> 여러 필터들이 겹쳐잇느데 다음 필터로 넘겨짐 마지막에는 서버로 넘김
		// doFilter하면 서블릿 컨테이너에서 서블릿 고르고 다시 옴
		
		
		System.out.println("수행시간(ns) : " + (System.nanoTime() - startTime));
		
		System.out.println("T08ServletFilter2.doFilter()" + " 끝...");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("T08ServletFilter2.init()" + " 호출됨");
	}

}
