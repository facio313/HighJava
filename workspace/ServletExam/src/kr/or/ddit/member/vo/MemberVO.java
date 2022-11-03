package kr.or.ddit.member.vo;

import java.util.Date;

/**
 * DB 테이블에 존재하는 컬럼이름을 기준으로 데이터를 객체화한 클래스 <br>
 * VO는 객체가 가질 수 있는 모든 정보를 담는 객체로서 그릇 역할을 함 <br>
 * 데이터 하나 하나를 주고 받는 것보다 객체를 주고 받는 것이 낫기 때문에 사용함 <br>
 * DTO와 비슷한 역할임(Data Transform Object) - 전송하는 데에 포커스를 맞추면 DTO가 맞고, 
 * 세부 정보를 담기 위한 것은 VO가 맞음
 * 
 * @author PC-08
 *
 *         <p>
 *         (보통 DB 테이블의 '컬럼'이 이 클래스의 '멤버변수'가 된다.)<br>
 *         DB 테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.<br>
 *         </p>
 *
 */
public class MemberVO {
	private String memId;
	private String memName;
	private String memTel;
	private String memAddr;
	private Date regDate;
	private long atchFileId = -1;

	
	
	public long getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return String.format("MemberVO [memId=%s, memName=%s, memTel=%s, memAddr=%s, regDate=%s]", memId, memName,
				memTel, memAddr, regDate);
	}

}
