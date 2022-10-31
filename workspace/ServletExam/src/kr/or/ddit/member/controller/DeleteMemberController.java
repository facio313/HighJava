 package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceimpl;

@WebServlet("/member/delete.do")
public class DeleteMemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 키 값 가져오기
		String memId = req.getParameter("memId");
		
		IMemberService memService = MemberServiceimpl.getInstance();
		
		int cnt = memService.removeMember(memId);
		
		
		resp.sendRedirect(req.getContextPath() + "/member/list.do"); // 브라우저 입장에서의 경로
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
