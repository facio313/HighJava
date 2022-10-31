package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceimpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet(value = "/member/list.do")
public class ListMemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 서비스 객체 생성하기
		IMemberService memService = MemberServiceimpl.getInstance();
		
		// 회원 목록 조회
		List<MemberVO> memList = memService.selectAllMember(); 
		
		// 잠깐 보관하기
		req.setAttribute("memList", memList);
		
		// 화면 목록 화면 처리하기(화면 그리는 건 jsp에 위임하기)
		// 화면 그리는 view한테 request를 dispatch하는 것
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/list.jsp");
		// jsp도 내부적으로 컴파일할 때 servlet임. 그래서 request와 response도 그대로 보냄(그대로 보내서 가공한 다음 리스트 출력을 화면에 보여줘야 함)
		dispatcher.forward(req, resp); // 클라이언트->WEB->WAS(Servlet Container(Controller->view(jsp))
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
