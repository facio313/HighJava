package kr.or.ddit.board;

import java.util.Date;

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private Date date;
	private String content;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format("BoardVO [no=%s, title=%s, writer=%s, date=%s, content=%s]", no, title, writer, date,
				content);
	}

}
