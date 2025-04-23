package com.team3.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.CheckBox;

/**
 *  (DTO)
 *  게시글 정보		
 *  				Java			DB
 *  - 게시글 번호		no				no	
 *  - 제목			title			title
 *  - 작성자			writer			writer
 *  - 내용			content			content
 *  - 등록일자			createdAt		created_date
 *  - 수정일자			updatedAt		updated_at
 */
		//모든생성자
public class Board {

	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private String updDate;
	private CheckBox cbDelete;
	
	// 날짜 형식
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public Board() {
		this("제목없음", "글쓴이없음", "내용없음");
	}
	public Board(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = dateFormat.format(new Date());
		this.updDate = dateFormat.format(new Date());
		this.cbDelete = new CheckBox();
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getUpdDate() {
		return updDate;
	}
	public void setUpdDate(String updDate) {
		this.updDate = updDate;
	}
	public CheckBox getCbDelete() {
		return cbDelete;
	}
	public void setCbDelete(CheckBox cbDelete) {
		this.cbDelete = cbDelete;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", updDate=" + updDate + "]";
	}
	
	
	
}