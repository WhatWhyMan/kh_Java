package kh.lclass.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public void testTcpServer(int port) {
		
		// 1. 서버의 포트번호 정함 ==> 프로그램의 포트번호
		// 7. close를 하기위해서 try문 밖에 선언을 해준다.
		ServerSocket ss = null;
		Socket sc = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		BufferedWriter wr = null;
		
		try {
			// 2. 서버용 소켓 객체 생성
			ss = new ServerSocket(port);
			
			while(true) {
				System.out.println("클라이언트 접속 대기 중......");
				// 3. 클라이언트 쪽에서 접속 요청이 오길 기다림 
				// 4. 접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성.
				sc = ss.accept();	// sc = 클라이언트를 계속 들어오게 하기 위해서는
									//		sc가 어려개 있어야한다.
				System.out.println("클라이언트 접속됨:"+sc.getPort());
				
				// 5. 연결된 클라이언트의 입출력 스트림 생성
				in = sc.getInputStream();
				out = sc.getOutputStream();
				// 6. 보조 스트림을 통해 성능 개선.
				br = new BufferedReader(new InputStreamReader(in));
				wr = new BufferedWriter(new OutputStreamWriter(out));
				
				String receivedMsg = null;
				while((receivedMsg = br.readLine()) != null){
					System.out.println("받은메시지 :"+receivedMsg);
					wr.write("메시지 잘 받았음.\n");
					wr.flush();
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				// Resource leak: '<unassigned Closeable value>' is never closed
				if(wr!=null) wr.close();
				if(br!=null) br.close();
				if(in!=null) in.close();
				if(out!=null) out.close();
				if(sc!=null) sc.close();
				if(ss!=null) ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
