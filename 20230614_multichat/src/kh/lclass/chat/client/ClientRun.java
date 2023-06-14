package kh.lclass.chat.client;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ClientRun {
	
	public static void main(String[] args) {
		// 사용자 nickname을 GUI를 통해서 입력받음.
		String nickName = JOptionPane.showInputDialog("닉네임을 입력해주세요!");
		new ClientGUI(nickName);
	}
}
