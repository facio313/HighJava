package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpSocektServerTest {
	public static void main(String[] args) throws IOException {
		
		// TCP 소켓 통신을 하기 위해 ServerSocket 객체 생성
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버가 접속을 기다립니다...");
		
		// accpet()메서드는 Client에서 연결 요청이 올 때까지 계속 기다린다.
		// 연결 요청이 오면 Socket객체를 생성해서 Client의 Socket과 연결됨.
		Socket socket = server.accept();
		
		//-----------------------------------------------------
		// 이 이후 클라이언트와 연결된 후의 작업을 진행하면 된다.
		
		System.out.println("접속한 클라이언트 정보");
		System.out.println("주소 : " + socket.getInetAddress());
		
		// Client에 메시지 보내기
		
		// OutputStream 객체를 구성하여 전송한다.
		// 접속한 Socket의 getOutputStream() 이용하여 구한다.
		OutputStream out = socket.getOutputStream();
		
		DataOutputStream dos = new DataOutputStream(out);
		
		dos.writeUTF("서버부터 켜셔야 합니다.");
		System.out.println("메시지를 보냈습니다.");
		
		dos.close();
	}
}
