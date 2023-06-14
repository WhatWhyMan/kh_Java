package kh.lclass.chat.server;

import javax.swing.JOptionPane;

public class ServerRun {

	public static void main(String[] args) {
		String nickName = JOptionPane.showInputDialog("닉네임을 입력해주세요.");
		new ServerGUI(nickName);	// 객체 생성 -> 생성자에 화면초기화 + event 등록 및 Visible 체크 -> 창 보여짐
	}
}
