package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class T06ServletSessionTest extends HttpServlet {
/*
 * 
 * HttpRequest랑 HttpResponse는 한 번 주고 받고 객체가 사라짐. 그래서 사용자별 정보를 저장하는 데에 적합하지 않음
 * 그래서 session을 씀 
 세션(HttpSession) 객체에 대하여... => 로그인에 접목(세션이 있다고 로그인된 건 아님. 로그인 체크는 다른 로직!)
 
 - 세션을 통해서 사용자(웹 브라우저)별로 구분하여 정보를 관리할 수 있다(세션ID 이용)
 - 세션은 각 사용자별 정보를 관리함
 - 쿠키를 사용할 때보다 보안이 향상된다.(서버에 정보가 저장되기 때문에)
 
 - 세션 객체를 가져오는 방법
 	HttpSession session = request.getSession(boolean 값)
 	boolean 값 : true인 경우 => 세션 객체가 존재하지 않으면 새로 생성
 				false인 경우 => 세션 객체가 존재하지 않으면 null 리턴
 				
 - 세션 삭제 처리 방법
 1. invalidate() 메서드 호출 - 로그아웃할 때 많이 씀
 2. setMaxInactiveInterval(int interval)호출
 => 일정시간(초) 동안 요청이 없으면 세션 객체 삭제됨
 3. web.xml에 <session-config> 설정하기(분 단위)
 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 세션을 가져오는데 없으면 새로 생성한다.
		HttpSession session = req.getSession(true);
		
		// 생성 시간 가져오기
		Date createTime = new Date(session.getCreationTime());
		
		// 마지막 접근 시간 가져오기
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		
		String title = "재방문을 환영합니다.";
		int visitCnt = 0; // 방문 횟수
		String userId = "in91"; // 사용자 ID
		
		if (session.isNew()) { // 새로 만든 세션인지...
			title = "처음 방문을 환영합니다.";
			session.setAttribute("userId", userId);
		} else {
			visitCnt = (int) session.getAttribute("visitCnt");
			visitCnt++; // 방문 횟수 추가
			userId = (String) session.getAttribute("userId");
		}
		session.setAttribute("visitCnt", visitCnt);
		
//		session.invalidate(); // 세션 삭제
		// 그래서 방문 횟수가 올라가지 않음
		// validate 유효화하다
		// invalidate 무효화하다
		
//		session.setMaxInactiveInterval(30); // 30초 시간 제한 - 국민취업지원제도 60분 로그인
		
		///////////////////////////////////////////////////////
		
		// 응답 시작
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
//		resp.setContentType("text/plain");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html><head><title>" + title
				+ "</title></head>"
				+ "<body>"
				+ "<h1 align=\"center\">" + title + "</h1>"
				+ "<h2 align=\"center\">세션정보</h2>"
				+ "<table border=\"1\" align=\"center\">"
				+ "<tr bgcolor=\"orange\">"
				+ "<th>구분</th><th>값</th></tr>"
				+ "<tr><td>세션ID</td><td>" 
				+ session.getId() + "</td></tr>"
				+ "<tr><td>생성 시간</td><td>" 
				+ createTime + "</td></tr>"
				+ "<tr><td>마지막 접근 시간</td><td>" 
				+ lastAccessTime + "</td></tr>"
				+ "<tr><td>User ID</td><td>" 
				+ userId + "</td></tr>"
				+ "<tr><td>방문 횟수</td><td>" 
				+ visitCnt + "</td></tr>"
				);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
	}
}
