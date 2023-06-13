package kh.lclass.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClient {
	public void testTcpClient(String severIp, int serverPort) {
		// 1. 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
		
		Socket socket = null;
		ServerSocket ss = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		// console에 입력한 문자 읽어들이기
		// Scanner 와 유사한 기능

		// 여기서 부터
		try {
			// 2. 서버용 소켓 객체 생성
			socket = new Socket(severIp, serverPort);
			System.out.println("서버에 접속했습니다.");
			
			// 5. 연결된 클라이언트의 입출력 스트림 생성
			System.out.println("");
			in = socket.getInputStream();
			out = socket.getOutputStream();
			// 6. 보조 스트림을 통해 성능 개선.
			br = new BufferedReader(new InputStreamReader(in));
			pw = new PrintWriter(new OutputStreamWriter(out));
			
			String sendMsg = null;
			
			while(true) {
				System.out.print("메시지>>");
				sendMsg = stdin.readLine();	
				// console에 입력한 문자 읽어들이기
				System.out.println("########"+sendMsg);
				// server로 문자 전송
				pw.println(sendMsg);
				pw.flush();
				// server로 부터 메시지 읽기
				String receivedMsg = br.readLine();
				System.out.println("서버로부터 받은메시지 :"+receivedMsg);
			}
//			pw.write("서비스 잘 부탁드립니다.");
//			pw.flush();
		
		// 여기까지 집중해서 보기(암기!)
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				// Resource leak: '<unassigned Closeable value>' is never closed
				if(pw!=null) pw.close();
				if(br!=null) br.close();
				if(in!=null) in.close();
				if(out!=null) out.close();
				if(socket!=null) socket.close();
				if(ss!=null) ss.close();
				if(stdin!=null) stdin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
		}
