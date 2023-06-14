package kh.lclass.chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -5930472044191273699L;
	
	private JTextArea jta = new JTextArea(40, 25);		 	// 채팅 창
	private JTextField jtf = new JTextField(25);			// 글 입력 부분
	
	private String nickname;								// 클라이언트 닉네임
	private ClientBackground cb = new ClientBackground();	// 채팅 Socket 기능을 담당할 객체.
	
	public ClientGUI(String nickname) {
		this.nickname = nickname;
		cb.setNickname(nickname);

		
		// 생성자에서는 초기화(즉 화면 초기화)
		setBounds(200, 100, 400, 600);						// 창이 뜨는 위치와 크기
		setTitle(nickname+"님 채팅창");
				
		jta.setEditable(false);								// 채팅창은 입력되지 않도록 함	
		jta.setFont(new Font("맑은고딕", Font.PLAIN, 18));	// 글자 폰트, 크기
		jta.setBackground(new Color(230, 255, 230));		// 글자 색상
			
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		cb.setGui(this);
		cb.connection();
	}
		// 새 메시지를 받았을 때 메소드 호출됨.
	public void appendMSG(String msg) {
		// jta(채팅방)에 msg를 추가함.
		jta.append(msg);
	}
	
	public void actionPerformed(ActionEvent e) {
		// 입력창에 글 입력하고 enter key를 눌렀을 때
		String msg = jtf.getText();
		System.out.println(msg);
		jtf.setText(""); 			// 입력창 입력된 글을 초기화
		// Server에 전달하기 위해 ClientBackground에 전달.
		cb.sendMessage(msg);
	}
}
