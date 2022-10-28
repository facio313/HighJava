package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T07ServletContextTest extends HttpServlet {
/*
	서블릿 컨텍스트 객체에 대하여...
	
	- 애플리케이션을 대표하는 객체, 웹 애플리케이션의 이름!
	
	1. 서블릿 프로그램이 컨테이너와 정보를 주고 받기 위한 메서드를 제공함
	ex) 파일의 MIME 타입 정보 가져오기, 요청 정보 보내기, 로깅 등
	
	2. 웹 애플리케이션당 1개씩 생성됨
	(애플리케이션이 살아있는 동안에는 유지되는 객체)
	항상 존재하는 전역적인 정보는 서블릿 컨텍스트에 저장하면 됨(setAttribute)
	
	3. 서블릿 컨텍스트 객체는 서블릿이 초기화될 때 ServletConfig 객체를 통해서 얻을 수 있다.
	
	- WebContent 폴더에 있는 게 실제 서비스하는 곳!
 
 */
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println(config.getServletContext());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext ctx = req.getServletContext();
		
		System.out.println("Servlet Context의 기본 경로 : " + ctx.getContextPath());
		System.out.println("Server 정보 : " +ctx.getServerInfo());
		System.out.println("Servlet API의 Major version 정보 : " + ctx.getMajorVersion());
		System.out.println("Servlet API의 Minior version 정보 : " + ctx.getMinorVersion());
		System.out.println("배포 기술자에 기술된 Context명 : " + ctx.getServletContextName());
		//  web.xml의 display name = 배포 기술자
		System.out.println("Resource 경로 목록 : " + ctx.getResourcePaths("/"));
		System.out.println("파일에 대한 MIME타입 정보 : " +  ctx.getMimeType("abc.mp4"));
		System.out.println("파일 시스템 상의 실제 경로 : " + ctx.getRealPath("/")); // 진짜 많이 씀
		
		// 속성값 설정
		ctx.setAttribute("attr1", "속성1");
		
		// 속성값 변경
		ctx.setAttribute("attr1", "속성2");
		
		// 속성값 가져오기
		System.out.println("attr1의 속성값 : " + ctx.getAttribute("attr1"));
		
		// 속성값 지우기
		ctx.removeAttribute("attr1");
		
		// 로깅 작업
		ctx.log("Servlet Context를 이용한 로깅 작업 중입니다...");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
