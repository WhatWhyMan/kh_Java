package kh.lclass.chat.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientBackground {
	private Socket socket;		// 필드는 따로 Close 안해줘도 됨. Garbage Collerction에 의해 Close 될 예정. 
	private BufferedReader br;
	private BufferedWriter bw;
	private String nickname;
	private ClientGUI gui;		// null	// new하면 안됨.
	
	public void disconnection() {	// Client가 서버에 접속.
		
		try {
			if(socket != null){
				socket.close();
			}
		} catch (Exception e) {
		}
	}
	
	// Client가 서버에 접속 -
	public void connection() {	// Client가 서버에 접속.
		
		try {
			socket = new Socket("127.0.0.1", 7777);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			bw.write(nickname+"\n 님이 접속하셨습니다.");
			// bw.flush
			
			// Server와 입력 통로가 끊어지지 않았다면 계속 반복함.
			// Server에서 수신받은 msg
			while(br != null) {
				String msg = br.readLine();
				gui.appendMSG(msg);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void sendMessage(String msg) {
		// server에 msg 전달
		try {
			bw.write(msg + "\n");
	//		bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void setNickname(String nickname) {
		this.nickname=nickname;
	}

	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}
	
	
	
}
