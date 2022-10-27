package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T07ServletContextTest extends HttpServlet {
/*
	서블릿 컨텍스트 객체에 대하여...
	
	1. 서블릿 프로그램이 컨테이너와 정보를 주고 받기 위한 메서드를 제공함
	ex) 파일의 MIME 타입 정보 가져오기, 요청 정보 보내기, 로깅 등
	
	2. 웹 애플리케이션당 1개씩 생성됨
	(애플리케이션이 살아있는 동안에는 유지되는 객체)
	항상 존재하는 전역적인 정보는 서블릿 컨텍스트에 저장하면 됨(setAttribute)
	
	3. 서블릿 컨텍스트 객체는 서블릿이 초기화될 때 ServletConfig 객체를 통해서 얻을 수 있다.
 
 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
