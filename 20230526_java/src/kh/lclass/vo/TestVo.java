package kh.lclass.vo;

public class TestVo {
	private int boardNuml;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	
//	생성자 - 생성자의 초기화를 위해서 기입 필요 / 안적을 시 JVM이 자동으로 기입
	public TestVo(int boardNuml, String boardWriter) {
	}
	
	public TestVo(int boardNuml) {
	}
	
//	all arguments 생성자
	public TestVo(int boardNuml, String boardWriter, String boardTitle, String boardContent, String boardDate) {
		this(boardNuml, boardWriter);
//		this.boardNuml = boardNuml;
//		this.boardWriter = boardWriter; 
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
	}
	
//	getter
	public int getBoardNuml() {
		return boardNuml;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	
//	setter
	public void setBoardNuml(int boardNuml) {
		this.boardNuml = boardNuml; 
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter; 
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle; 
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent; 
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate; 
	}
	
//	toString
	@Override
	public String toString() {
		return "[boardNuml="+boardNuml+", boardWriter="+boardWriter+", boardTitle="+boardTitle
			+", boardContent="+boardContent+", boardDate="+boardDate+"]";
	}
}
